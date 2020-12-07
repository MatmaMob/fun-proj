package com.example.anotheruselessapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anotheruselessapp.ElementRepository

class ElementViewModelFactory(private val elementRepository: ElementRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ElementViewModel(
            elementRepository
        ) as T
    }
}