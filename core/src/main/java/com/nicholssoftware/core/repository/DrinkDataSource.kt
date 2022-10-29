package com.nicholssoftware.core.repository

import com.nicholssoftware.core.data.Drink

interface DrinkDataSource {
    suspend fun get(id: Long): Drink?
    suspend fun getAll(): List<Drink>
    suspend fun add(drink: Drink)
    suspend fun remove(drink: Drink)
}