package info.aiavci.basicmvvm

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import info.aiavci.basicmvvm.data.Note.NoteDatabase

class App : Application(), LifecycleObserver {
    override fun onCreate() {
        super.onCreate()

        this.initDb()

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    private fun initDb() {
        NoteDatabase.init(this)
    }
}