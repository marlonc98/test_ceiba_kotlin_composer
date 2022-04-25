package com.lamzentertainment.testceiba.domain.entities

import com.lamzentertainment.testceiba.domain.repositories.IPostRepository

data class UserEntity(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    var posts: List<PostEntity>? = null
){
    suspend fun getPosts(postRepository: IPostRepository): List<PostEntity> {
        val tempPosts = postRepository.getPostsOfUserByUserId(id)
        this.posts = tempPosts
        return tempPosts
    }
}