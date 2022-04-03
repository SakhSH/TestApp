package com.example.testapp.main.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CocktailListResponse (

    @SerializedName("drinks")
    @Expose
    val drinks: List<CocktailDto>
)