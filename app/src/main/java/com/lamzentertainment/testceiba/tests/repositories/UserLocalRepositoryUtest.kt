package com.lamzentertainment.testceiba.tests.repositories

import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository

class UserLocalRepositoryUtest : IUserRepository {
    override suspend fun getUsers(page: Int, word: String): List<UserEntity> {
        return listOf(
            UserEntity(
                id = 1,
                name = "Juan",
                phone = "123456789",
                email = "juan@correo.com"),
            UserEntity(
                id = 2,
                name = "Pedro",
                phone = "123456789",
                email = "pedro@correo.com"),
            UserEntity(
                id = 3,
                name = "Jaime",
                phone = "123456789",
                email = "jaime@correo.com"))
    }

    override suspend fun getUser(id: Int): UserEntity? {
        return UserEntity(
            id = 3,
            name = "Jaime",
            phone = "123456789",
            email = "jaime@correo.com")
    }

    override suspend fun saveUser(user: UserEntity): Boolean {
        return true;
    }

    override suspend fun saveUsers(users: List<UserEntity>): Boolean {
        return true;
    }
}