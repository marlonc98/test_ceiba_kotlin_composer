package com.lamzentertainment.testceiba.data.remote.repositories.post

import com.google.common.truth.Truth
import com.lamzentertainment.testceiba.data.remote.repositories.user.UserApiRepository
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PostApiRepositoryTest {

    @Test
    suspend fun getPosts() {
        val response = PostApiRepository().getPosts();
        Truth.assertThat(response).isNotNull()
        Truth.assertThat(response).isNotEmpty()
    }

    @Test
    suspend fun getPostsOfUserByUserIdValid() {
        val response = PostApiRepository().getPostsOfUserByUserId(1);
        Truth.assertThat(response).isNotNull()
        Truth.assertThat(response).isNotEmpty()
    }

    @Test
    suspend fun getPostsOfUserByUserIdInvalid() {
        val response = PostApiRepository().getPostsOfUserByUserId(-1);
        Truth.assertThat(response).isNotNull()
        Truth.assertThat(response).isEmpty()
    }
}