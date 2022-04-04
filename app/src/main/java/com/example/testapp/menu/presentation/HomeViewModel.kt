package com.example.testapp.menu.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.menu.domain.usecases.GetAllCocktailsUseCase
import com.example.testapp.main.domain.models.CocktailList
import com.example.testapp.main.domain.models.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCocktailsUseCase: GetAllCocktailsUseCase,
) : ViewModel() {

    private val _screenState = MutableLiveData<ScreenState>()
    val screenState: LiveData<ScreenState> = _screenState

    private val _cocktailList = MutableLiveData<List<CocktailList>>()
    val cocktailList: LiveData<List<CocktailList>> = _cocktailList

    init {
        loadAllCocktails("m")
    }

    private fun loadAllCocktails(letter: String) {

        viewModelScope.launch {
            _screenState.value = ScreenState.Loading
            try {
                val cocktailsList = withContext(Dispatchers.IO) {
                    getAllCocktailsUseCase(letter)
                }
                withContext(Dispatchers.Main) {
                    _cocktailList.value = cocktailsList
                    _screenState.value = ScreenState.Content
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _screenState.value = ScreenState.Error("Нет соединения")
            }
        }
    }

}