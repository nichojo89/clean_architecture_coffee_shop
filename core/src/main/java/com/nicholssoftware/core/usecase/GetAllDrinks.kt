package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.repository.DrinkRepository

class GetAllDrinks(private val drinkRepository: DrinkRepository) {
    suspend operator fun invoke() = drinkRepository.GetAllDrinks()
}