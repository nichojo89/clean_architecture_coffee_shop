package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.data.Note
import com.nicholssoftware.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}