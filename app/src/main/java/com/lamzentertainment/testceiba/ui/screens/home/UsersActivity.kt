package com.lamzentertainment.testceiba.ui.screens.home

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lamzentertainment.testceiba.data.local.repositories.user.UserLocalRepository
import com.lamzentertainment.testceiba.data.remote.repositories.user.UserApiRepository
import com.lamzentertainment.testceiba.domain.use_cases.user.GetAllUsersUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UsersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersScreen()
        }
    }
}