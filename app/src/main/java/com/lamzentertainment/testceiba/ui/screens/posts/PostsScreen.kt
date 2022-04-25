package com.lamzentertainment.testceiba.ui.screens.posts

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lamzentertainment.testceiba.R
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.use_cases.user.GetUserWithPostsUseCase
import com.lamzentertainment.testceiba.tests.repositories.PostApiRepositoryUtest
import com.lamzentertainment.testceiba.tests.repositories.PostLocalRepositoryUtest
import com.lamzentertainment.testceiba.tests.repositories.UserApiRepositoryUtest
import com.lamzentertainment.testceiba.tests.repositories.UserLocalRepositoryUtest
import com.lamzentertainment.testceiba.ui.components.LoadingComponents
import com.lamzentertainment.testceiba.ui.components.MessageNoResults
import com.lamzentertainment.testceiba.ui.screens.posts.components.PostCardComponent
import com.lamzentertainment.testceiba.ui.screens.posts.components.UserInPostCardComponent
import com.lamzentertainment.testceiba.ui.theme.GreenCeiba700
import com.lamzentertainment.testceiba.ui.theme.TestCeibaTheme

@Composable
fun PostScreen(userId: Int) {
    var loaded by remember { mutableStateOf(false) }
    var user: UserEntity? by remember { mutableStateOf<UserEntity?>(null) }
    suspend fun getUserWithPosts() {
        val temp = GetUserWithPostsUseCase(UserLocalRepositoryUtest(), UserApiRepositoryUtest(), PostLocalRepositoryUtest(), PostApiRepositoryUtest(), userId).invoke()
        user = temp
        loaded = true
    }

    LaunchedEffect(true){
        //get intent userId
        getUserWithPosts()
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
            Box(Modifier.padding(16.dp)) {
            Column() {
                    if(!loaded) LoadingComponents()
                    else if (user == null) {
                        Text(
                            text = stringResource(id = R.string.user_not_found),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }else{
                        UserInPostCardComponent(user!!)

                        if (user!!.posts?.isEmpty() != false) {
                            MessageNoResults()
                        }
                        else Column() {
                            Text(
                                text = stringResource(id = R.string.posts_title),
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontWeight = FontWeight.Bold, color = GreenCeiba700),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(16.dp))
                            user!!.posts!!.map { post ->
                                PostCardComponent(post = post)
                            }
                        }
                    }

                }

            }
        }
    }
}
