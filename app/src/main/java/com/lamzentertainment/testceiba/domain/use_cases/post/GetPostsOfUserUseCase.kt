package com.lamzentertainment.testceiba.domain.use_cases.post

import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.repositories.IPostRepository

class GetPostsOfUserUseCase (private val localRepository: IPostRepository,private val apiRepository : IPostRepository) {
    suspend fun invoke(userId: Int) : List<PostEntity> {
        var postList: List<PostEntity> =  localRepository.getPostsOfUserByUserId(userId)
        if (postList.isEmpty()) {
            postList = apiRepository.getPostsOfUserByUserId(userId)
            localRepository.savePosts(postList)
        }
        return postList
    }
}