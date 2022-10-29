package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.data.Drink
import com.nicholssoftware.core.repository.DrinkRepository

class RemoveDrink(private val drinkRepository: DrinkRepository) {
    suspend operator fun invoke(drink: Drink) = drinkRepository.RemoveDrink(drink)
}