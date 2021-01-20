package com.example.anotheruselessapp.data.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.anotheruselessapp.data.entity.Element

@Dao
interface ElementDao {

    @Query("SELECT * FROM elements")
    fun getAllElements(): LiveData<List<Element>>

    @Query("SELECT * FROM elements")
    fun getAllElementsByPages(): DataSource.Factory<Int, Element>

    @Insert
    suspend fun insertElement(element: Element)

    @Delete
    suspend fun deleteElement(element: Element)

    @Update
    suspend fun updateElement(element: Element)
}