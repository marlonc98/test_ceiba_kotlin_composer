package com.lamzentertainment.testceiba.domain.use_cases.user

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth
import com.lamzentertainment.testceiba.data.local.repositories.user.UserLocalRepository
import com.lamzentertainment.testceiba.data.remote.repositories.user.UserApiRepository
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetAllUsersUseCaseTest {
    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    suspend fun isValid() {
        val response =GetAllUsersUseCase(UserLocalRepository(instrumentationContext), UserApiRepository(), 1, "").invoke()
        val justLocal = UserLocalRepository(instrumentationContext).getUsers(1, "");
        val justApi = UserApiRepository().getUsers(1, "");
        Truth.assertThat(justLocal.isNotEmpty() && justLocal == response).isEqualTo(true)
        Truth.assertThat(justLocal.isEmpty() && justApi.isNotEmpty() && justApi == response).isEqualTo(true)
    }

    @Test
    suspend fun isInvalid(){
        val word = "Leanne"
        val response =GetAllUsersUseCase(UserLocalRepository(instrumentationContext), UserApiRepository(), 1, "").invoke()
        val responseFiltred =GetAllUsersUseCase(UserLocalRepository(instrumentationContext), UserApiRepository(), 1, word).invoke().filter { it.toString().contains(word) }
        Truth.assertThat(response == responseFiltred).isEqualTo(true)

    }
}