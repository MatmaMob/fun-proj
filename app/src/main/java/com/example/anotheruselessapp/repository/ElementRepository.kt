package com.example.anotheruselessapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import androidx.room.Room
import com.example.anotheruselessapp.data.db.AppDatabase
import com.example.anotheruselessapp.data.entity.Element
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ElementRepository(context: Context) {

    private val db: AppDatabase by lazy {
        Room.databaseBuilder(context, AppDatabase::class.java, "db_elements")
            .fallbackToDestructiveMigration()
            .build()
    }

    private val elementDao by lazy {
        db.elementDao()
    }

    fun getAllPagedElements(): LiveData<PagedList<Element>> =
        elementDao.getAllElementsByPages().toLiveData(pageSize = 2)

    fun getAllElements(): LiveData<List<Element>> = elementDao.getAllElements()

    suspend fun insertElement(element: Element) {
        withContext(Dispatchers.IO) {
            elementDao.insertElement(element)
        }
    }

    suspend fun deleteElement(element: Element) {
        withContext(Dispatchers.IO) {
            elementDao.deleteElement(element)
        }
    }

    suspend fun updateElement(element: Element) {
        withContext(Dispatchers.IO) {
            elementDao.updateElement(element)
        }
    }
}