package com.example.anotheruselessapp.di

import android.content.Context
import com.example.anotheruselessapp.repository.ElementRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object UselessModule {

    @Provides
    fun providesRepository(@ActivityContext context: Context): ElementRepository =
        ElementRepository(context)
}