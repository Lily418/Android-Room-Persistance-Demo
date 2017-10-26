package com.example.lily.roomtest

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by Lily Hoskin on 25/10/2017.
 */

@Dao
interface PersonDao {
    @Query("select * from person")
    fun getAllPeople(): List<Person>

    @Query("select * from person where id = :id")
    fun findPersonById(id: Long): PersonAndPets

    @Insert(onConflict = REPLACE)
    fun insertPerson(person: Person) : Long

    @Update(onConflict = REPLACE)
    fun updatePerson(person: Person)

    @Delete
    fun deletePerson(person: Person)
}