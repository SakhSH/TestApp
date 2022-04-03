package com.example.testapp.main.data.api

import android.app.Application
import com.example.testapp.main.domain.MemeRepository
import javax.inject.Inject

class MemeRepositoryImpl @Inject constructor(
    application: Application,
    private val apiService: ApiService,
) : MemeRepository {


}