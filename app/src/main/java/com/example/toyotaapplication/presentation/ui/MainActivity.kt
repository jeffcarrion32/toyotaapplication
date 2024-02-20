package com.example.toyotaapplication.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toyotaapplication.domain.model.NetworkStateResponse
import com.example.toyotaapplication.domain.model.User
import com.example.toyotaapplication.domain.model.UserResponse
import com.example.toyotaapplication.presentation.ui.theme.ToyotaApplicationTheme
import com.example.toyotaapplication.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: UserViewModel by viewModels()
        super.onCreate(savedInstanceState)

        viewModel.makeRequest()
        setContent {
            ToyotaApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UsersList(
                        viewModel.response.collectAsState()
                    )
                }
            }
        }
    }
}

@Composable
fun UsersList(
    response: State<NetworkStateResponse>
) {
    Log.d("response", "$response")
    when(response.value) {
        is NetworkStateResponse.Success -> {
            UsersListDisplay((response.value as NetworkStateResponse.Success).response)
        }

        is NetworkStateResponse.Loading -> {

        }

        is NetworkStateResponse.Failed -> {

        }
    }
}

@Composable
fun UsersListDisplay(usersResponse: UserResponse?) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        usersResponse?.users?.forEach {
            UserListItem(users = it)
        }
    }
}

@Composable
fun UserListItem(users: User) {
    Log.d("USERNAME", users.firstName)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            Text(text = users.firstName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToyotaApplicationTheme {

    }
}