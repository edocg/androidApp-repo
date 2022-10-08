package com.example.usersapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel: ViewModel() {
    var users: StateFlow<List<User>> = MutableStateFlow(emptyList())
    private set

    fun fetchUsers(){
        val userFromSource= listOf(
            User("Eduardo 1","Android Developer","Usuario Eduardo"),
            User("Eduardo 2","Android Developer","Usuario Eduardo"),
            User("Eduardo 3","Android Developer","Usuario Eduardo"),
            User("Eduardo 4","Android Developer","Usuario Eduardo"),
            User("Eduardo 5","Android Developer","Usuario Eduardo"),
            User("Eduardo 6","Android Developer","Usuario Eduardo"),
            User("Eduardo 7","Android Developer","Usuario Eduardo"),
            User("Eduardo 8","Android Developer","Usuario Eduardo"),
            User("Eduardo 9","Android Developer","Usuario Eduardo"),
            User("Eduardo10","Android Developer","Usuario Eduardo"),
        )
        users = MutableStateFlow(userFromSource)
    }
}
