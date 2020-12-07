package com.example.anotheruselessapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.anotheruselessapp.data.entity.Element

@Dao
interface ElementDao {

    @Query("SELECT * FROM elements")
    fun getAllElements(): LiveData<List<Element>>

    @Insert
    suspend fun insertElement(element: Element)

    @Delete
    suspend fun deleteElement(element: Element)

    @Update
    suspend fun updateElement(element: Element)
}