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

abstract class RoomConnectedActivity : AppCompatActivity() {

    val database: AppDatabase
    get() = Database.appDatabase(applicationContext)
}
