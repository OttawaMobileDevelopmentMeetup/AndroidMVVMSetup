package info.aiavci.basicmvvm.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import info.aiavci.basicmvvm.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

//        mainTextView
        mainViewModel.userLiveData.observe(this@MainActivity, {
            findViewById<TextView>(R.id.mainTextView).text = getString(R.string.welcome_logged_in, it.name, it.email)
        })

        performFakeLogin()
    }

    fun performFakeLogin() {
        mainViewModel.setUser("123", "Jane Doe", "jane@doe.com")
    }
}