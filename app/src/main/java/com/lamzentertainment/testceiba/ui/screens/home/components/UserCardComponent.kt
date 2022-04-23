package com.lamzentertainment.testceiba.ui.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.lamzentertainment.testceiba.domain.entities.UserEntity

@Composable
fun UserCardComponent(user: UserEntity) {
    Card() {
        Column() {
            Text(text = user.name)
            Text(text = user.email)
            Text(text = user.phone)
        }
    }

}