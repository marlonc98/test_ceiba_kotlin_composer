package com.lamzentertainment.testceiba.data.local.repositories.user

import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository

class UserLocalRepository : IUserRepository {
    override suspend fun getUsers(): List<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun saveUser(user: UserEntity): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun saveUsers(users: List<UserEntity>): Boolean {
        TODO("Not yet implemented")
    }
}