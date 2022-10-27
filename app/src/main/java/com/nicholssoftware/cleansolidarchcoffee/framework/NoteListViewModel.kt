package com.nicholssoftware.cleansolidarchcoffee.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nicholssoftware.core.data.Note
import com.nicholssoftware.core.repository.NoteRepository
import com.nicholssoftware.core.usecase.AddNote
import com.nicholssoftware.core.usecase.GetAllNotes
import com.nicholssoftware.core.usecase.GetNote
import com.nicholssoftware.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteListViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){
        coroutineScope.launch{
            val noteList = useCases.getAllNotes()
            notes.postValue(noteList)
        }
    }
}