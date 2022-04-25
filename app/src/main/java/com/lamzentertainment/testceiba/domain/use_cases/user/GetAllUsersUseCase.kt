package com.lamzentertainment.testceiba.domain.use_cases.user

import android.util.Log
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository

class GetAllUsersUseCase (
    private val localRepository: IUserRepository,
    private val apiRepository: IUserRepository,
    private val page: Int,
    private val word: String) {
    suspend fun invoke() : List<UserEntity> {
        var userList: List<UserEntity> = localRepository.getUsers(page, word)
        Log.v("GetAllUsersUseCase", "Local: ${userList.size}")
        if (userList.isEmpty()) {
            userList = apiRepository.getUsers(page, word)
            if (userList.isNotEmpty()) {
                localRepository.saveUsers(userList)
            }
        }

       return userList.filter { it.toString().contains(word) }
    }
}