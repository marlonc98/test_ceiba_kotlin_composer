package com.lamzentertainment.testceiba.domain.use_cases.post

import com.lamzentertainment.testceiba.data.local.repositories.post.PostLocalRepository
import com.lamzentertainment.testceiba.data.remote.repositories.post.PostApiRepository
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.repositories.IPostRepository

class GetPostsOfUserUseCase  {
    suspend fun execute(userId: Int) : List<PostEntity> {
        val localRepository: IPostRepository = PostLocalRepository()
        val apiRepository : IPostRepository = PostApiRepository()
        var postList: List<PostEntity> =  localRepository.getPostsOfUserByUserId(userId)
        if (postList.isEmpty()) {
            postList = apiRepository.getPostsOfUserByUserId(userId)
        }
        return postList
    }
}