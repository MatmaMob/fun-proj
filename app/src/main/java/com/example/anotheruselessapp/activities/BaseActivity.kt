package com.example.anotheruselessapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.anotheruselessapp.viewmodel.ElementViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

open class BaseActivity : AppCompatActivity() {

    lateinit var viewModel: ElementViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()

    }
}
