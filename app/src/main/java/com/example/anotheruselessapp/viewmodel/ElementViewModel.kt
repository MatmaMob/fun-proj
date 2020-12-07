package com.example.anotheruselessapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.anotheruselessapp.ElementRepository
import com.example.anotheruselessapp.data.entity.Element

class ElementViewModel(private val elementRepository: ElementRepository) : ViewModel() {

    private val elementTrigger = MutableLiveData(Unit)

    private fun loadData(): LiveData<List<Element>> = elementRepository.getAllElements()

    val element: LiveData<List<Element>> = elementTrigger.switchMap {
        loadData()
    }

    fun refresh() {
        elementTrigger.value = Unit
    }

    suspend fun insertElement(element: Element) {
        elementRepository.insertElement(element)
    }

    suspend fun deleteElement(element: Element) {
        elementRepository.deleteElement(element)
    }

    suspend fun updateElement(element: Element) {
        elementRepository.updateElement(element)
    }
}