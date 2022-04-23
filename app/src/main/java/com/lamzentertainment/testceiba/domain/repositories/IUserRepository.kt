package com.lamzentertainment.testceiba.domain.repositories

import com.lamzentertainment.testceiba.domain.entities.UserEntity

interface IUserRepository {
    suspend fun getUsers(): List<UserEntity>
}