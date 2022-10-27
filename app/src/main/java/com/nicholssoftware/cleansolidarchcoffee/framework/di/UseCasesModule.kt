package com.nicholssoftware.cleansolidarchcoffee.framework.di

import com.nicholssoftware.cleansolidarchcoffee.framework.UseCases
import com.nicholssoftware.core.repository.NoteRepository
import com.nicholssoftware.core.usecase.AddNote
import com.nicholssoftware.core.usecase.GetAllNotes
import com.nicholssoftware.core.usecase.GetNote
import com.nicholssoftware.core.usecase.RemoveNote
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) =
        UseCases(
            AddNote(repository),
            GetAllNotes(repository),
            GetNote(repository),
            RemoveNote(repository)
        )
}