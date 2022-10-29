package com.nicholssoftware.cleansolidarchcoffee.framework.di

import com.nicholssoftware.cleansolidarchcoffee.framework.HomeViewModel
import com.nicholssoftware.cleansolidarchcoffee.framework.NoteListViewModel
import com.nicholssoftware.cleansolidarchcoffee.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: NoteListViewModel)
    fun inject(drinkViewModel: HomeViewModel)
}