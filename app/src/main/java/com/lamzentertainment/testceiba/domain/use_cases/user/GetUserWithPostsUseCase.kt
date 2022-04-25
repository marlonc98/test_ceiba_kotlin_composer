package com.lamzentertainment.testceiba.domain.use_cases.user

import android.util.Log
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IPostRepository
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository

class GetUserWithPostsUseCase (
    private val localUserRepository: IUserRepository,
    private val apiUserRepository: IUserRepository,
    private val localPostRepository: IPostRepository,
    private val apiPostRepository: IPostRepository,
    private val userId: Int
    )
{
    suspend fun invoke():UserEntity?{
        var user:UserEntity? = localUserRepository.getUser(userId)
        if (user == null){
            val user = apiUserRepository.getUser(userId) ?: return null
        }
        var posts = user!!.getPosts(localPostRepository);
        Log.v("GetUserWithPostsUseCase", "posts: ${posts.size}")
        if(posts.isEmpty()){
            posts = user!!.getPosts(apiPostRepository);
            if (posts.isNotEmpty()){
                val response = localPostRepository.savePosts(posts)
                Log.v("GetUserWithPostsUseCase", "posts saved: ${response}")
            }
        }
        return user;
    }
}