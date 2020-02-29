package com.kptech.cinema

import android.app.Application
import android.util.Log

class App : Application()
{
    companion object{
        lateinit var prefs : MySharedPreferences
    }

    override fun onCreate() {
        Log.d("MainActivity","App Create")
        prefs = MySharedPreferences(applicationContext)
        super.onCreate()

    }
}