package info.aiavci.basicmvvm.data.Note

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by Ali Avci
 * Version
 */
@Dao
interface NoteDao {

    @Query("SELECT * from note_table ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAll()
}