package com.example.testapp.main.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktails_items")
    fun getListDB(): List<CocktailDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListDB(meme: CocktailDbModel)

    @Query("SELECT count(*)!=0 FROM cocktails_items WHERE id=:memeInfoId ")
    fun containsPrimaryKey(memeInfoId: Int): Boolean
}