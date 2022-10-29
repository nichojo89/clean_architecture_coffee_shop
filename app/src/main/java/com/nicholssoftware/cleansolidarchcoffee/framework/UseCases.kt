package com.nicholssoftware.cleansolidarchcoffee.framework

import com.nicholssoftware.core.usecase.*

data class UseCases(

    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val getWordCount: GetWordCount,
    val addDrink: AddDrink,
    val removeDrink: RemoveDrink,
    val getAllDrinks: GetAllDrinks,
    val getDrink: GetDrink
)