package info.aiavci.basicmvvm.data.Note

import android.app.Application
import androidx.lifecycle.LiveData

class NoteRepository(application: Application) {

    private var noteDao: NoteDao
    var allNotes: LiveData<List<Note>>

    init {
        val db = NoteDatabase.getDatabase(application)
        noteDao = db.noteDao()

        allNotes = noteDao.getAllNotes()
    }

    fun update(note: Note) {
        noteDao.update(note)
    }

    fun delete(note: Note) {
        noteDao.delete(note)
    }

    fun insert(note: Note) {
        noteDao.insert(note)
    }
}