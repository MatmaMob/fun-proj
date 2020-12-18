package com.example.anotheruselessapp.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.anotheruselessapp.repository.ElementRepository
import com.example.anotheruselessapp.viewmodel.ElementViewModel
import com.example.anotheruselessapp.viewmodel.ElementViewModelFactory

open class BaseActivity : AppCompatActivity() {

    protected val viewModel: ElementViewModel by viewModels {
        ElementViewModelFactory(
            ElementRepository(
                applicationContext
            )
        )
    }
}
