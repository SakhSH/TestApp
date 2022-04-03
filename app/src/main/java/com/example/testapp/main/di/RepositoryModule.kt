package com.example.testapp.main.di

import com.example.testapp.main.data.api.CocktailsRepositoryImpl
import com.example.testapp.main.domain.CocktailRepository
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
    fun provideMemeRepository(impl: CocktailsRepositoryImpl): CocktailRepository
}