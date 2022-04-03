package com.example.testapp.main.data.api

import com.example.testapp.main.data.models.CocktailListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("search.php?f={$LETTER}")
    suspend fun getCocktailList(@Path(LETTER) letter: String) : CocktailListResponse

    companion object {
        private const val LETTER = "letter"
    }
}