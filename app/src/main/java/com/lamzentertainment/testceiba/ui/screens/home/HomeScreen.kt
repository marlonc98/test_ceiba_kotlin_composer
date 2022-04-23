package com.lamzentertainment.testceiba.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.ui.screens.home.components.UserCardComponent
import com.lamzentertainment.testceiba.ui.theme.TestCeibaTheme
import com.lamzentertainment.testceiba.ui.utils.KHomeScreenTitle

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val listTestNames: List<UserEntity> = listOf(
        UserEntity(
            id = "1",
            name = "Juan",
            email = "micorreo@mail.com",
            phone = "123456789",
        ))
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
                listTestNames.map { user ->
                    UserCardComponent(user)
                }
            }
        }
    }
}
