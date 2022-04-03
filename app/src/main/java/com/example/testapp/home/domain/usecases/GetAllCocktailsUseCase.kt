package com.example.testapp.home.domain.usecases

import com.example.testapp.main.domain.CocktailRepository
import com.example.testapp.main.domain.models.CocktailList
import javax.inject.Inject

class GetAllCocktailsUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    suspend operator fun invoke(letter: String): List<CocktailList> =
        cocktailRepository.getAllCocktails(letter)
}