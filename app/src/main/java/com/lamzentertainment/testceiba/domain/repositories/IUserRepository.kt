package com.lamzentertainment.testceiba.domain.repositories

import com.lamzentertainment.testceiba.domain.entities.UserEntity

interface IUserRepository {
    suspend fun getUsers(page: Int, word: String): List<UserEntity>
    suspend fun getUser(id: Int): UserEntity?
    suspend fun saveUser(user: UserEntity): Boolean
    suspend fun saveUsers(users: List<UserEntity>): Boolean
}