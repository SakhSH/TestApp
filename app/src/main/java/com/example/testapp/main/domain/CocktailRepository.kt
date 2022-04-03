package com.example.testapp.main.domain

import com.example.testapp.main.domain.models.CocktailList

interface CocktailRepository {

    suspend fun getAllCocktails(letter: String): List<CocktailList>

    suspend fun addFavoriteCocktailList(meme: CocktailList)

    suspend fun containsPrimaryKey(memeId: Int): Boolean
}