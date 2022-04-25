package com.lamzentertainment.testceiba.data.local.repositories.post

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PostLocalRepositoryTest {
    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }
    
    @Test
    suspend fun getPost() {
        val result = PostLocalRepository(instrumentationContext).getPosts()
        assertThat(result is List<PostEntity>).isEqualTo(true)
    }

    @Test
    suspend fun getPostsOfUserByUserIdIsValid() {
        val userId = 1
        val result = PostLocalRepository(instrumentationContext).getPostsOfUserByUserId(userId)
        assertThat(userId <= 0 && result.isEmpty()).isEqualTo(true)
    }

    @Test
    suspend fun getPostsOfUserByUserIdIsInvalid() {
        val userId = 1
        val result = PostLocalRepository(instrumentationContext).getPostsOfUserByUserId(userId)
        assertThat(userId <= 0 && result.isEmpty()).isEqualTo(true)
    }

    @Test
    suspend fun savePostIsValid() {
        val post = PostEntity(1,  1, "title", "body")
        val result = PostLocalRepository(instrumentationContext).savePost(post)
        assertThat(result).isEqualTo(true)
    }

    @Test
    suspend fun savePostsIsValid() {
        val posts = listOf(PostEntity(1,  1, "title", "body"), PostEntity(2,  1, "title", "body"))
        val result = PostLocalRepository(instrumentationContext).savePosts(posts)
        assertThat(result).isEqualTo(true)
    }

    @Test
    suspend fun savePostsIsInvalid(){
        val posts = listOf(PostEntity(1,  1, "title", "body"), PostEntity(1,  1, "title", "body"))
        val result = PostLocalRepository(instrumentationContext).savePosts(posts)
        assertThat(result).isEqualTo(false)
    }

}