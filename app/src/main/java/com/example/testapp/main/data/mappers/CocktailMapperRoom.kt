package com.example.testapp.main.data.mappers

import com.example.testapp.main.data.database.CocktailDbModel
import com.example.testapp.main.data.models.CocktailDto
import com.example.testapp.main.domain.models.CocktailList
import javax.inject.Inject

class CocktailMapperRoom @Inject constructor() {

    fun mapDtoToDbModel(cocktailList: CocktailList) = CocktailDbModel(
        id = cocktailList.id,
        bottomText = cocktailList.bottomText,
        image = cocktailList.image,
        topText = cocktailList.topText
    )

    fun mapDbModelToEntity(dbModel: CocktailDbModel) = CocktailList(
        id = dbModel.id,
        bottomText = dbModel.bottomText,
        image = dbModel.image,
        topText = dbModel.topText
    )
}
