package com.lamzentertainment.testceiba.data.local.repositories.post

import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.repositories.IPostRepository

class PostLocalRepository : IPostRepository {
    override suspend fun getPosts(): List<PostEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getPostsOfUserByUserId(userId: Int): List<PostEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun savePosts(posts: List<PostEntity>): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun savePost(post: PostEntity): Boolean {
        TODO("Not yet implemented")
    }
}