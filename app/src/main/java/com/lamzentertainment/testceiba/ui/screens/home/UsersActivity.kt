package com.lamzentertainment.testceiba.ui.screens.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class UsersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersScreen()
        }
    }
}