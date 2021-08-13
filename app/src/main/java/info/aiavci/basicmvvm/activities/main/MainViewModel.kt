package info.aiavci.basicmvvm.activities.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import info.aiavci.basicmvvm.data.Note.Note
import info.aiavci.basicmvvm.data.Note.NoteRepository
import info.aiavci.basicmvvm.data.User

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val userLiveData = MutableLiveData<User>()

    private val noteRepository: NoteRepository by lazy {
        NoteRepository(application)
    }

    var allNotes: LiveData<List<Note>> = noteRepository.allNotes

    fun setUser(userId: String, name: String, email: String) {
        userLiveData.value = User(userId, name, email)
    }


    fun insertNote(note: Note) {
        noteRepository.insert(note)
    }

    fun delete(note: Note) {
        noteRepository.delete(note)
    }

    fun update(note: Note) {
        noteRepository.update(note)
    }
}