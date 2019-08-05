package com.example.ctdrecviewtutorial.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ctdrecviewtutorial.models.Note
import kotlin.random.Random

class MyViewModel : ViewModel() {

    private val _myNotes: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val myNotes: LiveData<MutableList<Note>> = _myNotes

    init {
        val notes = mutableListOf(
            Note("Test Note 1", "This is a test note.  It is not private"),
            Note("Test Note 2", "Another test note.  This one is private", true)
        )
        _myNotes.postValue(notes)
    }

    val noteTitles = listOf(
        "Random Title",
        "Some other thing",
        "Another note",
        "More Notes",
        "Random Title ${Random.nextInt()}"
    )

    val noteContent = listOf(
        "Here is some content to go in one of the notes.  It is not creative at all.",
        "Lorem ipsum cogito sum dolor cuthulu flitang glenfathum",
        "Call me ishmael, it was the best of times, it was the worst of times, please sir I'd like some more",
        "What did you just say, person within fireball distance"
    )

    fun addNote() {
        val list = _myNotes.value
        list?.add(Note(noteTitles.random(), noteContent.random(), arrayOf(true, false).random()))
        _myNotes.postValue(list)
    }

    fun deleteNote(note: Note) {
        val list = _myNotes.value
        list?.remove(note)
        _myNotes.postValue(list)
    }
}