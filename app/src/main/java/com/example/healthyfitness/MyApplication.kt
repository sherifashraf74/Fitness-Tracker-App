package com.example.healthyfitness

import android.app.Application
import android.content.Context
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application(){

    init {
        application = this
    }

    companion object {
        private lateinit var application: MyApplication
        fun getApplicationContext(): Context = application.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}