package com.nicholssoftware.cleansolidarchcoffee.framework.di

import android.app.Application
import com.nicholssoftware.cleansolidarchcoffee.framework.HomeViewModel
import com.nicholssoftware.cleansolidarchcoffee.framework.MainViewModel
import com.nicholssoftware.cleansolidarchcoffee.framework.NoteListViewModel
import com.nicholssoftware.cleansolidarchcoffee.framework.NoteViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: NoteListViewModel)
    fun inject(drinkViewModel: HomeViewModel)
    fun inject(mainViewModel: MainViewModel)
}