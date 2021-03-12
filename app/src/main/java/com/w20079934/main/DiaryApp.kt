package com.w20079934.main


import EntryJSONStore
import android.app.Application
import com.w20079934.models.EntryStore

class DiaryApp : Application() {
    lateinit var entries : EntryStore


    override fun onCreate() {
        super.onCreate()
        entries = EntryJSONStore(applicationContext)


    }
}