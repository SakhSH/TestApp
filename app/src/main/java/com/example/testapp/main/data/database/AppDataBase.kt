package com.example.testapp.main.data.database

import android.app.Application
import androidx.room.*

@Database(entities = [CocktailDbModel::class],
    version = 1,
    exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()
        private const val DB_NAME = "cocktail_item.db"

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDataBase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}