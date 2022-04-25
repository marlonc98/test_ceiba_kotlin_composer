package com.lamzentertainment.testceiba.data.remote.repositories.post

import android.util.Log
import com.google.gson.Gson
import com.lamzentertainment.testceiba.data.remote.dto.post.PostApiDto
import com.lamzentertainment.testceiba.data.remote.dto.post.toPost
import com.lamzentertainment.testceiba.data.remote.dto.user.UserApiDto
import com.lamzentertainment.testceiba.data.remote.repositories.HttpApi
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.repositories.IPostRepository
import okhttp3.ResponseBody

class PostApiRepository : IPostRepository {
    override suspend fun getPosts(): List<PostEntity> {
        val response: ResponseBody = HttpApi().get("/posts") ?: return listOf()
        val postsDto = Gson().fromJson<List<PostApiDto>>(response!!.string(), Array<PostApiDto>::class.java)
        return postsDto.map { it.toPost() }
    }

    override suspend fun getPostsOfUserByUserId(userId: Int): List<PostEntity> {
        val response: ResponseBody = HttpApi().get("/posts?userId=${userId}") ?: return listOf()
        return try{
            val stringResponse = response.string()
            val postsDto = Gson().fromJson<Array<PostApiDto>>(stringResponse, Array<PostApiDto>::class.java)
            postsDto.map { it.toPost() }
        }catch (e: Exception){
            listOf()
        }
    }

    override suspend fun savePosts(posts: List<PostEntity>): Boolean {
        return true
    }

    override suspend fun savePost(post: PostEntity): Boolean {
        return true
    }
}