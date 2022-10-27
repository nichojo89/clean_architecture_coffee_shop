package com.nicholssoftware.cleansolidarchcoffee.framework

import com.nicholssoftware.core.usecase.AddNote
import com.nicholssoftware.core.usecase.GetAllNotes
import com.nicholssoftware.core.usecase.GetNote
import com.nicholssoftware.core.usecase.RemoveNote

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)