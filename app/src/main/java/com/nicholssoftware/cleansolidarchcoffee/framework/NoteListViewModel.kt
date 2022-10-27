package com.nicholssoftware.cleansolidarchcoffee.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nicholssoftware.cleansolidarchcoffee.framework.di.ApplicationModule
import com.nicholssoftware.cleansolidarchcoffee.framework.di.DaggerViewModelComponent
import com.nicholssoftware.core.data.Note
import com.nicholssoftware.core.repository.NoteRepository
import com.nicholssoftware.core.usecase.AddNote
import com.nicholssoftware.core.usecase.GetAllNotes
import com.nicholssoftware.core.usecase.GetNote
import com.nicholssoftware.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteListViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){
        coroutineScope.launch{
            val noteList = useCases.getAllNotes()
            notes.postValue(noteList)
        }
    }
}