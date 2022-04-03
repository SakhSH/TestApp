package com.example.testapp.main.di

import com.example.testapp.main.data.api.MemeRepositoryImpl
import com.example.testapp.main.domain.MemeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun provideMemeRepository(impl: MemeRepositoryImpl): MemeRepository
}