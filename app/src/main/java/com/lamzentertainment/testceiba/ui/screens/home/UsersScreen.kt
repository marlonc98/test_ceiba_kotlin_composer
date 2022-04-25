package com.lamzentertainment.testceiba.ui.screens.home

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lamzentertainment.testceiba.R
import com.lamzentertainment.testceiba.data.local.repositories.user.UserLocalRepository
import com.lamzentertainment.testceiba.data.remote.repositories.user.UserApiRepository
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.use_cases.user.GetAllUsersUseCase
import com.lamzentertainment.testceiba.tests.repositories.UserApiRepositoryUtest
import com.lamzentertainment.testceiba.tests.repositories.UserLocalRepositoryUtest
import com.lamzentertainment.testceiba.ui.components.LoadingComponents
import com.lamzentertainment.testceiba.ui.components.MessageNoResults
import com.lamzentertainment.testceiba.ui.screens.home.components.UserCardComponent
import com.lamzentertainment.testceiba.ui.screens.posts.components.UserInPostCardComponent
import com.lamzentertainment.testceiba.ui.theme.GreenCeiba700
import com.lamzentertainment.testceiba.ui.theme.TestCeibaTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

suspend fun getUsers(context : Context, word: String) : List<UserEntity> {
    return  GetAllUsersUseCase(UserLocalRepository(context), UserApiRepository(), 1, word).invoke()
}


@SuppressLint("CoroutineCreationDuringComposition")
@Preview(showBackground = true)
@Composable
fun UsersScreen() {
    val context = LocalContext.current
    var listUsers by remember { mutableStateOf<List<UserEntity>?>(null) }
    var searchWord by remember {
        mutableStateOf("")
    }

    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        GlobalScope.launch {
            listUsers = getUsers(context,searchWord)
        }
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
                    label = { Text(text = stringResource(R.string.home_screen_user_hint)) },
                    onValueChange = {
                        searchWord = it
                        GlobalScope.launch {
                            listUsers = getUsers(context, searchWord)
                        }
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedLabelColor = GreenCeiba700,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Box(Modifier.padding(16.dp)) {
                    if (listUsers == null) LoadingComponents()
                    else if (listUsers!!.isEmpty()) MessageNoResults()
                    else Column() {
                        listUsers!!.map { user ->
                            UserCardComponent(user)
                        }
                    }
                }

            }
        }
    }
}
