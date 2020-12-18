package com.example.anotheruselessapp

import android.app.Application
import com.example.anotheruselessapp.repository.ElementRepository
import com.example.anotheruselessapp.viewmodel.ElementViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class UselessApp : Application() {

    private val viewModelModule = module {
        single { ElementRepository(get()) }
        viewModel { ElementViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UselessApp)
            modules(viewModelModule)
        }
    }
}