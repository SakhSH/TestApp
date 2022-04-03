package com.example.testapp.main.data.api

import com.example.testapp.main.data.models.CocktailListResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search.php")
    suspend fun getCocktailList(@Query(LETTER) letter: String): CocktailListResponse

    companion object {
        private const val LETTER = "f"
    }
}