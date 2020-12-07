package com.example.anotheruselessapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.anotheruselessapp.data.entity.Element

@Database(entities = arrayOf(Element::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun elementDao(): ElementDao
}