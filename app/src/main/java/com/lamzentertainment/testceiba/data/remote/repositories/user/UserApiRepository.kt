package com.lamzentertainment.testceiba.data.remote.repositories.user

import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository

class UserApiRepository : IUserRepository {
    override suspend fun getUsers(page: Int, word: String): List<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun saveUser(user: UserEntity): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun saveUsers(users: List<UserEntity>): Boolean {
        TODO("Not yet implemented")
    }
}