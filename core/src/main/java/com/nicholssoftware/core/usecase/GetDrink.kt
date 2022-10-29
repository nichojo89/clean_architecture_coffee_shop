package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.data.Drink
import com.nicholssoftware.core.repository.DrinkRepository

class GetDrink(private val drinkRepository: DrinkRepository) {
    suspend operator fun invoke(id: Long) = drinkRepository.GetDrink(id)
}