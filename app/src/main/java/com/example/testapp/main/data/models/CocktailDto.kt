package com.example.testapp.main.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CocktailDto(

    @SerializedName("idDrink")
    @Expose
    val id: Int,
    @SerializedName("strDrink")
    @Expose
    val topText: String?,
    @SerializedName("strInstructions")
    @Expose
    val bottomText: String?,
    @SerializedName("strImageSource")
    @Expose
    val image: String?
)
