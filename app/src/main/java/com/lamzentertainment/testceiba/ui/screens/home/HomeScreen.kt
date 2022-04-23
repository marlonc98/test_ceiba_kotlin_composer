package com.lamzentertainment.testceiba.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.ui.components.MessageNoResults
import com.lamzentertainment.testceiba.ui.screens.home.components.UserCardComponent
import com.lamzentertainment.testceiba.ui.theme.GreenCeiba700
import com.lamzentertainment.testceiba.ui.theme.TestCeibaTheme
import com.lamzentertainment.testceiba.ui.utils.KHomeScreenTitle
import com.lamzentertainment.testceiba.ui.utils.KHomeSearchUserHint

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val (listUsers, setListUsers) = remember { mutableStateOf<List<UserEntity>>(listOf<UserEntity>()) }

    TestCeibaTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = KHomeScreenTitle) },
                )
            }
        ) {
            Column() {
                TextField(value = "",
                    label = { Text(text = KHomeSearchUserHint)},
                    onValueChange = {},
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
