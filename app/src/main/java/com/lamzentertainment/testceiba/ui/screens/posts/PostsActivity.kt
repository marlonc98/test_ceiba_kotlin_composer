package com.lamzentertainment.testceiba.ui.screens.posts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class PostsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userId = intent.getIntExtra("id", 0)
        setContent {
            PostScreen(userId)
        }
    }
}