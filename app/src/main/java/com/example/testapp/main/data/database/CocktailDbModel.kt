package com.example.testapp.main.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails_items")
data class CocktailDbModel (

    @PrimaryKey
    val id: Int,
    val topText: String,
    val bottomText: String,
    val image: String
)