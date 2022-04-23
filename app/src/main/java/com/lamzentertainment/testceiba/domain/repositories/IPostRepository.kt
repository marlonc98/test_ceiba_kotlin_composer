package com.lamzentertainment.testceiba.domain.repositories

import com.lamzentertainment.testceiba.domain.entities.PostEntity
import java.util.concurrent.Future

interface IPostRepository {
    suspend fun getPosts(): List<PostEntity>
    suspend fun getPostsOfUserByUserId(): List<PostEntity>
}