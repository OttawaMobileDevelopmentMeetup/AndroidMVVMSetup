package info.aiavci.basicmvvm.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import info.aiavci.basicmvvm.R
import info.aiavci.basicmvvm.data.Note.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainTextView
        mainViewModel.userLiveData.observe(this@MainActivity, {
            findViewById<TextView>(R.id.mainTextView).text =
                getString(R.string.welcome_logged_in, it.name, it.email)
        })

        mainViewModel.allNotes.observe(this@MainActivity, {
            findViewById<TextView>(R.id.noteTitlesTextView).text =
                it.joinToString { note -> "Note ${note.noteTitle}" }
        })

        performFakeLogin()

        findViewById<Button>(R.id.submitButton).setOnClickListener {
            createFakeNote()
        }
    }

    fun performFakeLogin() {
        mainViewModel.setUser("123", "Jane Doe", "jane@doe.com")
    }

    fun createFakeNote() {
        GlobalScope.launch(Dispatchers.Default) {  // replaces doAsync
            mainViewModel.insertNote(
                Note(
                    "Great weather today",
                    "Today's weather was absolutely great."
                )
            )
        }
    }
}