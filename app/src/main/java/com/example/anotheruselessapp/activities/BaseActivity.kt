package com.example.anotheruselessapp.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.anotheruselessapp.viewmodel.ElementViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ElementViewModel
}
