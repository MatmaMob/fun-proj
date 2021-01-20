package com.example.anotheruselessapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.paging.PagedList
import com.example.anotheruselessapp.repository.ElementRepository
import com.example.anotheruselessapp.data.entity.Element

class ElementViewModel(private val elementRepository: ElementRepository) : ViewModel() {

    val testString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val elementTrigger = MutableLiveData(Unit)

    private fun loadData(): LiveData<PagedList<Element>> = elementRepository.getAllPagedElements()

    val element: LiveData<PagedList<Element>> = elementTrigger.switchMap {
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