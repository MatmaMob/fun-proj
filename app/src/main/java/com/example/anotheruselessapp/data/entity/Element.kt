package com.example.anotheruselessapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.anotheruselessapp.data.Priority

@Entity(tableName = "elements")
data class Element(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "description")
    val description: String = "",
    @ColumnInfo(name = "priority")
    val priority: String = Priority.LOW.name,
    @ColumnInfo(name = "done")
    var isDone: Boolean = false

)