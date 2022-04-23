package com.lamzentertainment.testceiba.domain.use_cases.post

import com.lamzentertainment.testceiba.data.local.repositories.post.PostLocalRepository
import com.lamzentertainment.testceiba.data.remote.repositories.post.PostApiRepository
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.repositories.IPostRepository
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

class GetAllPostsUseCase {
    suspend fun execute() : List<PostEntity> {
        val localRepository: IPostRepository = PostLocalRepository()
        val apiRepository : IPostRepository = PostApiRepository()
        var postList: List<PostEntity> =  localRepository.getPosts()
        if (postList.isEmpty()) {
            postList = apiRepository.getPosts()
        }
        return postList
    }
}