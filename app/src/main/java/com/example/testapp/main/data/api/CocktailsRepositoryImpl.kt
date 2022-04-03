package com.example.testapp.main.data.api

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.testapp.main.data.database.AppDataBase
import com.example.testapp.main.data.mappers.CocktailMapper
import com.example.testapp.main.data.mappers.CocktailMapperRoom
import com.example.testapp.main.domain.CocktailRepository
import com.example.testapp.main.domain.models.CocktailList
import com.example.testapp.main.domain.models.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    application: Application,
    private val apiService: ApiService,
    private val mapper: CocktailMapper,
    private val mapperRoom: CocktailMapperRoom
) : CocktailRepository {

    private val cocktailDao = AppDataBase.getInstance(application).cocktailDao()

    override suspend fun getAllCocktails(letter: String): List<CocktailList> {
        return try {
            val cocktails = apiService.getCocktailList(letter)
            val list = mapper.mapAllCocktailsDto(cocktails.drinks)
            withContext(Dispatchers.IO){
                launch {
                    list.forEach {
                        if (!containsPrimaryKey(it.id)) {
                            addFavoriteCocktailList(it)
                        }
                    }
                }
            }
            list
        } catch (e: Exception) {
            val list = getFavoriteCocktailList()
            list
        }
    }

    private fun getFavoriteCocktailList(): List<CocktailList> {
        return cocktailDao.getListDB().map{
            mapperRoom.mapDbModelToEntity(it)
        }
    }

    override suspend fun addFavoriteCocktailList(cocktailList: CocktailList) {
        cocktailDao.insertListDB(mapperRoom.mapDtoToDbModel(cocktailList))
    }

    override suspend fun containsPrimaryKey(id: Int): Boolean {
        return cocktailDao.containsPrimaryKey(id)
    }
}