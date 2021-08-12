package info.aiavci.basicmvvm.activities.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.aiavci.basicmvvm.data.User

class MainViewModel() : ViewModel() {
    val userLiveData = MutableLiveData<User>()

    fun setUser(userId: String, name: String, email: String) {
        userLiveData.value = User(userId, name, email)
    }
}