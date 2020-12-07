package com.example.anotheruselessapp

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.anotheruselessapp.viewmodel.ElementViewModel
import com.example.anotheruselessapp.viewmodel.ElementViewModelFactory

open class BaseActivity : AppCompatActivity() {

    protected val viewModel: ElementViewModel by viewModels {
        ElementViewModelFactory(
            ElementRepository(applicationContext)
        )
    }
}
