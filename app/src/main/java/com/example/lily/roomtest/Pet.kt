package com.example.lily.roomtest

import android.arch.persistence.room.*

/**
 * Created by lily on 25/10/2017.
 */

@Entity(tableName = "pet",
        foreignKeys = arrayOf(ForeignKey(entity = Person::class, parentColumns = arrayOf("id"), childColumns = arrayOf("person_id"))))
class Pet {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var uid: Long = 0

    @ColumnInfo(name = "person_id")
    var personId: Long = 0

    @ColumnInfo(name = "name")
    lateinit var name: String
}