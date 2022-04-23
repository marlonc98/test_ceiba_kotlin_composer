package com.lamzentertainment.testceiba.data.remote.repositories.user

import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository

class UserApiRepository : IUserRepository {
    override suspend fun getUsers(): List<UserEntity> {
        TODO("Not yet implemented")
    }
}