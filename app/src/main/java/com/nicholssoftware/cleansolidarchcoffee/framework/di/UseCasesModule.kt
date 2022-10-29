package com.nicholssoftware.cleansolidarchcoffee.framework.di

import com.nicholssoftware.cleansolidarchcoffee.framework.UseCases
import com.nicholssoftware.core.repository.DrinkRepository
import com.nicholssoftware.core.repository.NoteRepository
import com.nicholssoftware.core.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(noteRepository: NoteRepository, drinkRepository: DrinkRepository) =
        UseCases(
            AddNote(noteRepository),
            GetAllNotes(noteRepository),
            GetNote(noteRepository),
            RemoveNote(noteRepository),
            GetWordCount(),
            AddDrink(drinkRepository),
            RemoveDrink(drinkRepository),
            GetAllDrinks(drinkRepository),
            GetDrink(drinkRepository)
        )
}