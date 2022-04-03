package com.example.testapp.main.di

import com.example.testapp.main.data.api.ApiFactory
import com.example.testapp.main.data.api.MemeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun providesMemeApiService(): MemeApiService = ApiFactory.apiService
}