package com.example.anotheruselessapp

import android.app.Application
import androidx.room.Room
import com.example.anotheruselessapp.data.db.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UselessApp : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}