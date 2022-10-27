package com.nicholssoftware.cleansolidarchcoffee.framework.di

import android.app.Application
import com.nicholssoftware.cleansolidarchcoffee.framework.RoomNoteDataSource
import com.nicholssoftware.core.repository.NoteRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}