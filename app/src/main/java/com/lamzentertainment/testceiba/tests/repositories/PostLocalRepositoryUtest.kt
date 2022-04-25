package com.lamzentertainment.testceiba.tests.repositories

import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IPostRepository

class PostLocalRepositoryUtest: IPostRepository {
    override suspend fun getPosts(): List<PostEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getPostsOfUserByUserId(userId: Int): List<PostEntity> {
        return listOf(
        )
    }

    override suspend fun savePosts(posts: List<PostEntity>): Boolean {
        return true
    }

    override suspend fun savePost(post: PostEntity): Boolean {
        TODO("Not yet implemented")
    }
}