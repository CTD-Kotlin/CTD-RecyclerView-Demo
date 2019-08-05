package com.example.ctdrecviewtutorial.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ctdrecviewtutorial.models.Note

class MyViewModel : ViewModel() {

    private val _myNotes: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val myNotes: LiveData<MutableList<Note>> = _myNotes
    init {
        val notes = mutableListOf(Note("Test Note 1", "This is a test note.  It is not private"),
            Note("Test Note 2", "Another test note.  This one is private", true)
        )
        _myNotes.postValue(notes)
    }

    fun addNote(note: Note) {
        val list = _myNotes.value
        list?.add(note)
        _myNotes.postValue(list)
    }

    fun deleteNote(note: Note) {
        val list = _myNotes.value
        list?.remove(note)
        _myNotes.postValue(list)
    }
}