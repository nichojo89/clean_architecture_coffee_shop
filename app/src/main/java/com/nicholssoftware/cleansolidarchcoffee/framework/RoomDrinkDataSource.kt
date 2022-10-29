package com.nicholssoftware.cleansolidarchcoffee.framework

import android.content.Context
import com.nicholssoftware.cleansolidarchcoffee.framework.db.DatabaseService
import com.nicholssoftware.cleansolidarchcoffee.framework.db.DrinkEntity
import com.nicholssoftware.core.data.Drink
import com.nicholssoftware.core.repository.DrinkDataSource

class RoomDrinkDataSource(context: Context): DrinkDataSource {
    val drinkDao = DatabaseService.getInstance(context).drinkDao()

    override suspend fun get(id: Long): Drink? =
        drinkDao.getDrinkEntity(id)!!.toDrink()

    override suspend fun getAll(): List<Drink> =
        drinkDao.getAllDrinkEntities().map { it.toDrink() }

    override suspend fun add(drink: Drink) =
        drinkDao.addDrinkEntity(DrinkEntity.fromDrink(drink))

    override suspend fun remove(drink: Drink) =
        drinkDao.deleteDrinkEntity(DrinkEntity.fromDrink(drink))
}