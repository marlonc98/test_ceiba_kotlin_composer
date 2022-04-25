package com.lamzentertainment.testceiba.data.remote.repositories.user

import android.util.Log
import com.google.gson.Gson
import com.lamzentertainment.testceiba.data.remote.dto.user.UserApiDto
import com.lamzentertainment.testceiba.data.remote.dto.user.toUser
import com.lamzentertainment.testceiba.data.remote.repositories.HttpApi
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository
import okhttp3.ResponseBody

class UserApiRepository : IUserRepository {
    override suspend fun getUsers(page: Int, word: String): List<UserEntity> {
        val response: ResponseBody = HttpApi().get("/users") ?: return listOf()
        val stringResponse = response.string()
        val usersDto = Gson().fromJson<Array<UserApiDto>>(stringResponse, Array<UserApiDto>::class.java)
        return usersDto.map { it.toUser() }
    }

    override suspend fun getUser(id: Int): UserEntity? {
        val response: ResponseBody = HttpApi().get("/users/${id}") ?: return null
        val userDto = Gson().fromJson<UserApiDto>(response.string(), UserApiDto::class.java)
        return userDto.toUser()
    }

    override suspend fun saveUser(user: UserEntity): Boolean {
        return true
    }

    override suspend fun saveUsers(users: List<UserEntity>): Boolean {
        return true
    }
}