package com.example.usersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.usersapp.ui.theme.UsersAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersAppTheme {
                Scaffold(content = { UsersList() })
            }
        }
    }

    @Composable
    private fun UsersList(userViewModel: UserViewModel = viewModel()) {
        userViewModel.fetchUsers()
        val users by userViewModel.users.collectAsState()
        LazyColumn{
            items(users.size){
                UserMenuContent(user=users[it])
            }
        }
    }

    @Composable
        private fun UserMenuContent(user: User) {
            Row {
                Image(painter = painterResource(id = R.drawable.ic_silueta),
                    contentDescription = user.contentDescription)
                Column() {
                    Text(user.name, style = MaterialTheme.typography.h6)
                    Text(user.role, style = MaterialTheme.typography.caption)
                }
            }
        }
    @Preview(showBackground = true)
    @Composable
    fun UserMenuContentPreview() {
        UsersAppTheme {
            UserMenuContent(User("","",""))
        }
    }
}



