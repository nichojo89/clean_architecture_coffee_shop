package com.nicholssoftware.cleansolidarchcoffee.framework.di

import android.app.Application
import com.nicholssoftware.cleansolidarchcoffee.framework.RoomDrinkDataSource
import com.nicholssoftware.cleansolidarchcoffee.framework.RoomNoteDataSource
import com.nicholssoftware.core.repository.DrinkRepository
import com.nicholssoftware.core.repository.NoteRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideNoteRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))

    @Provides
    fun providesDrinkRepository(app: Application) = DrinkRepository(RoomDrinkDataSource(app))
}