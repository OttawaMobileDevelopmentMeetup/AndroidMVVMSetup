package info.aiavci.basicmvvm.data.Note

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        var INSTANCE: NoteDatabase? = null

        internal fun getDatabase(context: Context): NoteDatabase {
            if (INSTANCE == null) {
                synchronized(NoteDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            NoteDatabase::class.java, "note_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }

        fun init(context: Context): NoteDatabase =
            Room.databaseBuilder(context, NoteDatabase::class.java, "note_database").build()
    }

}