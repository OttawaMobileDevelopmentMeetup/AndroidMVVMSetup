package info.aiavci.basicmvvm.data.Note

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(
    @NonNull var noteTitle: String? = null,
    @NonNull var noteContent: String? = null,
    edittedId: Int? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    init {
        if (edittedId != null) {
            id = edittedId
        }
    }
}