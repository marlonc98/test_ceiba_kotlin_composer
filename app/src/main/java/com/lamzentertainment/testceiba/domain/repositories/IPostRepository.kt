package com.lamzentertainment.testceiba.domain.repositories

import com.lamzentertainment.testceiba.domain.entities.PostEntity

interface IPostRepository {
    suspend fun getPosts(): List<PostEntity>
    suspend fun getPostsOfUserByUserId(userId: Int): List<PostEntity>
    suspend fun savePosts(posts: List<PostEntity>): Boolean
    suspend fun savePost(post: PostEntity): Boolean
}