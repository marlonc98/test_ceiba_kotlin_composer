package com.lamzentertainment.testceiba.data.remote.repositories.user

import com.google.common.truth.Truth
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserApiRepositoryTest {

    @Test
    suspend fun getUsers() {
        val response = UserApiRepository().getUsers(1, "");
        Truth.assertThat(response).isNotNull()
        Truth.assertThat(response).isNotEmpty()
    }

    @Test
    suspend fun getUser() {
        val response = UserApiRepository().getUser(1);
        val byFilterOfAll = UserApiRepository().getUsers(1,"").find { it.id == 1 }
        Truth.assertThat(response).isNotNull()
        Truth.assertThat(response).isEqualTo(byFilterOfAll)
    }

}