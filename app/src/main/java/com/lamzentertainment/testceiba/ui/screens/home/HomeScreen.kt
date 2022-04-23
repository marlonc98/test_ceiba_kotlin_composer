package com.lamzentertainment.testceiba.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lamzentertainment.testceiba.R
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.use_cases.user.GetAllUsersUseCase
import com.lamzentertainment.testceiba.tests.repositories.UserApiRepositoryUtest
import com.lamzentertainment.testceiba.tests.repositories.UserLocalRepositoryUtest
import com.lamzentertainment.testceiba.ui.components.MessageNoResults
import com.lamzentertainment.testceiba.ui.screens.home.components.UserCardComponent
import com.lamzentertainment.testceiba.ui.theme.GreenCeiba700
import com.lamzentertainment.testceiba.ui.theme.TestCeibaTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    var listUsers by remember { mutableStateOf<List<UserEntity>>(listOf<UserEntity>()) }
    var searchWord by remember {
        mutableStateOf("")
    }
    listUsers =  listOf(
        UserEntity(
            id = 1,
            name = "Jorge",
            phone = "123456789",
            email = "jorge@correo.com"),
        UserEntity(
            id = 2,
            name = "Manuel",
            phone = "123456789",
            email = "manuel@correo.com"),
        UserEntity(
            id = 3,
            name = "Federico",
            phone = "123456789",
            email = "ferico@correo.com"))

    suspend fun getUsers() {
        val temp = GetAllUsersUseCase(UserLocalRepositoryUtest(), UserApiRepositoryUtest(), 1, "").invoke()
            listUsers = temp
        Log.v("HomeScreen", "listUsers: ${listUsers.size}")
    }

    LaunchedEffect(true){
            getUsers()
    }

    TestCeibaTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.home_screen_title)) },
                )
            }
        ) {
            Column() {
                TextField(
                    value = searchWord,
                    label = { Text(text = stringResource(R.string.home_screen_user_hint))},
                    onValueChange = {
                        searchWord = it
                        GlobalScope.launch { getUsers() }
                                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedLabelColor = GreenCeiba700,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp))
                Box(Modifier.padding(16.dp)) {
                if (listUsers.isEmpty()) MessageNoResults()
                else Column() {
                        listUsers.map { user ->
                            UserCardComponent(user)
                        }
                    }
                }

            }
        }
    }
}
