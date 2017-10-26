package com.example.lily.roomtest

import android.arch.persistence.room.Room
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.content.Intent



val UID_OF_PERSON_MESSAGE = "com.example.lily.roomtest.UID_OF_PERSON_MESSAGE"

class MainActivity : RoomConnectedActivity() {

    private val myAdapter = MyAdapter()


    fun seedDatabase() {
        val personDao = database.personDao()
        val petDao = database.petDao()

        val allPeople = personDao.getAllPeople()
        if(allPeople.isEmpty()) {
            val people = arrayOf("Finn", "Laila", "Lily", "Uve", "Jamie", "Nicky")
            people.forEach {
                val person = Person()
                person.name = it
                val id = personDao.insertPerson(person)
                person.uid = id

                if(it == "Lily") {
                    val pet = Pet()
                    pet.name = "Summer"
                    pet.personId = person.uid
                    petDao.insertPet(pet)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        seedDatabase()

        val personDao = database.personDao()
        personDao.getAllPeople().forEach {
            myAdapter.addPerson(it)
        }
    }

    fun addPerson(view: View) {
        val textInput = findViewById<EditText>(R.id.personName)
        val newName = textInput.text.toString()
        val personDao = database.personDao()
        val newPerson = Person().apply {
            this.name = newName
        }

        newPerson.uid = personDao.insertPerson(newPerson)

        myAdapter.addPerson(newPerson)
        val inputMethodService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodService.hideSoftInputFromWindow(textInput.windowToken, 0)

        textInput.setText("")

        findViewById<RecyclerView>(R.id.recycler_view).scrollToPosition(personDao.getAllPeople().size - 1)
    }

    fun showPerson(view: View) {
        val intent = Intent(this, DetailView::class.java)
        intent.putExtra(UID_OF_PERSON_MESSAGE, view.tag as Long)
        startActivity(intent)
    }
}
