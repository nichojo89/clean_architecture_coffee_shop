package com.nicholssoftware.core.repository

import com.nicholssoftware.core.data.Drink

class DrinkRepository(private val drinkDataSource: DrinkDataSource) {
    suspend fun AddDrink(drink: Drink) = drinkDataSource.add(drink)
    suspend fun RemoveDrink(drink: Drink) = drinkDataSource.remove(drink)
    suspend fun GetDrink(id: Long) = drinkDataSource.get(id)
    suspend fun GetAllDrinks() = drinkDataSource.getAll()
}