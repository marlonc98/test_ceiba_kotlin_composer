package com.lamzentertainment.testceiba.domain.use_cases.user

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth
import com.lamzentertainment.testceiba.data.local.repositories.post.PostLocalRepository
import com.lamzentertainment.testceiba.data.local.repositories.user.UserLocalRepository
import com.lamzentertainment.testceiba.data.remote.repositories.post.PostApiRepository
import com.lamzentertainment.testceiba.data.remote.repositories.user.UserApiRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetUserWithPostsUseCaseTest {
    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    suspend fun isValid() {
        val response = GetUserWithPostsUseCase(
            localPostRepository = PostLocalRepository(instrumentationContext),
            localUserRepository = UserLocalRepository(instrumentationContext),
            apiPostRepository = PostApiRepository(),
            apiUserRepository = UserApiRepository(),
            userId = 1
        ).invoke()
        val postUser = PostApiRepository().getPostsOfUserByUserId(1)
        val postLocalUser = PostLocalRepository(instrumentationContext).getPostsOfUserByUserId(1)
        Truth.assertThat(response == null || response.posts != null).isTrue()
        Truth.assertThat(response?.posts == postUser).isTrue()
        Truth.assertThat(response?.posts == postLocalUser).isTrue()
    }

    @Test
    suspend fun isInvalid(){
        val response = GetUserWithPostsUseCase(
            localPostRepository = PostLocalRepository(instrumentationContext),
            localUserRepository = UserLocalRepository(instrumentationContext),
            apiPostRepository = PostApiRepository(),
            apiUserRepository = UserApiRepository(),
            userId = 1
        ).invoke()
        Truth.assertThat(response?.posts == null).isTrue()
    }
}