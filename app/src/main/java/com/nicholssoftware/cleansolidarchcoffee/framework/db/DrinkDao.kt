package com.nicholssoftware.cleansolidarchcoffee.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.nicholssoftware.core.data.Drink

@Dao
interface DrinkDao {

    @Insert(onConflict = REPLACE)
    suspend fun addDrinkEntity(drink: DrinkEntity)

    @Query("SELECT * FROM drink WHERE id = :id")
    suspend fun getDrinkEntity(id: Long): DrinkEntity?

    @Query("SELECT * FROM drink")
    suspend fun getAllDrinkEntities(): List<DrinkEntity>

    @Delete
    suspend fun deleteDrinkEntity(drink: DrinkEntity)
}