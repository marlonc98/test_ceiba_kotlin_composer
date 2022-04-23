package com.lamzentertainment.testceiba.tests.repositories

import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository

class UserApiRepositoryUtest : IUserRepository {
    override suspend fun getUsers(page: Int, word: String): List<UserEntity> {
        return listOf(
            UserEntity(
                id = 1,
                name = "Jorge",
                phone = "123456789",
                email = "jorge@correo.com"),
            UserEntity(
                id = 2,
                name = "Manuel",
                phone = "123456789",
                email = "manuel@correo.com"),
            UserEntity(
                id = 3,
                name = "Federico",
                phone = "123456789",
                email = "ferico@correo.com"))
    }

    override suspend fun saveUser(user: UserEntity): Boolean {
        return true;
    }

    override suspend fun saveUsers(users: List<UserEntity>): Boolean {
        return true;
    }
}