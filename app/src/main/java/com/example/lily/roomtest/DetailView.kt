package com.example.lily.roomtest

import android.os.Bundle
import android.widget.TextView

class DetailView : RoomConnectedActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)
        val textView: TextView = findViewById(R.id.textView)
        val personId = intent?.getLongExtra(UID_OF_PERSON_MESSAGE, 0)
        val person = database.personDao().findPersonById(personId!!)
        val pets = person.pets?.map { it.name }

        if(pets != null && pets!!.size > 0) {
            textView.text = person.name + " has pets " + pets.joinToString()
        } else {
            textView.text = person.name + " has no pets 😢"
        }
    }


}
