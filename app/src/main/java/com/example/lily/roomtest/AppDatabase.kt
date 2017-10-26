package com.example.lily.roomtest

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by Lily Hoskin on 25/10/2017.
 */

@Database(entities = arrayOf(Person::class, Pet::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun petDao(): PetDao
}

class Database {

    companion object {
        private var _appDatabase: AppDatabase? = null



        fun appDatabase(applicationContext : Context): AppDatabase {

            if(_appDatabase == null) {
                _appDatabase = Room
                        .databaseBuilder(applicationContext, AppDatabase::class.java, "pets-database")
                        .allowMainThreadQueries()
                        .build()
            }

            return _appDatabase!!
        }
    }
}