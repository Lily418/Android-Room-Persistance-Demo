package com.example.lily.roomtest

import android.arch.persistence.room.*
import android.arch.persistence.room.Embedded



/**
 * Created by lily on 25/10/2017.
 */

@Entity(tableName = "person")
class Person {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var uid: Long = 0

    @ColumnInfo(name = "name")
    lateinit var name: String
}

class PersonAndPets {
    @ColumnInfo(name = "id")
    var uid: Long = 0

    @ColumnInfo(name = "name")
    lateinit var name: String

    @Relation(parentColumn = "id", entityColumn = "person_id")
    var pets: List<Pet>? = null
}