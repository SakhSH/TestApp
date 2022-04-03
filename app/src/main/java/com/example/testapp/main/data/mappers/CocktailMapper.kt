package com.example.testapp.main.data.mappers

import com.example.testapp.main.data.models.CocktailDto
import com.example.testapp.main.domain.models.CocktailList
import javax.inject.Inject

class CocktailMapper @Inject constructor() {

    fun mapAllCocktailsDto(dtoItems: List<CocktailDto>) = dtoItems.map(::mapCocktailDto).filter{ it.image != null }

    private fun mapCocktailDto(dtoItem: CocktailDto) = with(dtoItem){

        CocktailList(
            id = id,
            topText = topText,
            bottomText = bottomText,
            image = image
        )

    }
}