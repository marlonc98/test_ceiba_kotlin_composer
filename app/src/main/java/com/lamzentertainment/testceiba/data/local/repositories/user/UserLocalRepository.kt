package com.lamzentertainment.testceiba.data.local.repositories.user

import android.content.Context
import com.lamzentertainment.testceiba.data.local.config.LocalSqlite
import com.lamzentertainment.testceiba.data.local.config.tables.PostSqlite
import com.lamzentertainment.testceiba.data.local.config.tables.UserSqlite
import com.lamzentertainment.testceiba.data.local.dto.PostLocalDto
import com.lamzentertainment.testceiba.data.local.dto.UserLocalDto
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IUserRepository

class UserLocalRepository(private val context: Context) : IUserRepository {
    override suspend fun getUsers(page: Int, word: String): List<UserEntity> {
        return getFromSqlite("SELECT * FROM ${UserSqlite.TABLE_NAME}")
    }

    override suspend fun getUser(id: Int): UserEntity? {
        return try {
            getFromSqlite("SELECT * FROM ${UserSqlite.TABLE_NAME} WHERE ${UserSqlite.COLUMN_ID} = $id").first()
        }catch (e: Exception){
            null
        }
    }
    override suspend fun saveUser(user: UserEntity): Boolean {
        val dbHelper = LocalSqlite(context)
        return try {
            dbHelper.writableDatabase.execSQL("" +
                    "INSERT INTO ${UserSqlite.TABLE_NAME}" +
                    " (${UserSqlite.COLUMN_NAME}, ${UserSqlite.COLUMN_EMAIL}," +
                    " ${UserSqlite.COLUMN_PHONE})" +
                    " VALUES (?, ?, ?, ?)",
                arrayOf(user.id,
                    user.name,
                    user.email,
                    user.phone))
            true
        }catch (e: Exception){
            false
        }    }

    override suspend fun saveUsers(users: List<UserEntity>): Boolean {
        var responseFinal = true
        users.forEach{
            val response = saveUser(it)
            if(!response){
                responseFinal = false
            }
        }
        return responseFinal
    }

    private fun getFromSqlite(sql: String): List<UserEntity> {
        val dbHelper = LocalSqlite(context)
        return try {
            val users : MutableList<UserEntity> = mutableListOf()
            dbHelper.readableDatabase.rawQuery(sql, null).use {
                val userGetted = UserLocalDto.toUser(it)
                users.add(userGetted)
            }
            users.toList()
        }catch (e: Exception){
            listOf()
        }
    }
}