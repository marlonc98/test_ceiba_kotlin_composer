package com.lamzentertainment.testceiba.data.local.repositories.post

import android.content.Context
import com.google.gson.Gson
import com.lamzentertainment.testceiba.data.local.config.LocalSqlite
import com.lamzentertainment.testceiba.data.local.config.tables.PostSqlite
import com.lamzentertainment.testceiba.data.local.dto.PostLocalDto
import com.lamzentertainment.testceiba.data.local.dto.UserLocalDto
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import com.lamzentertainment.testceiba.domain.repositories.IPostRepository
import org.json.JSONArray
import org.json.JSONObject

class PostLocalRepository(private val context: Context) : IPostRepository {
    override suspend fun getPosts(): List<PostEntity> {
        return getFromSqlite("SELECT * FROM ${PostSqlite.TABLE_NAME}")
    }

    override suspend fun getPostsOfUserByUserId(userId: Int): List<PostEntity> {
        return getFromSqlite("SELECT * FROM ${PostSqlite.TABLE_NAME} Where ${PostSqlite.COLUMN_USER_ID} = $userId")
    }

    override suspend fun savePosts(posts: List<PostEntity>): Boolean {
        var responseFinal = true
        posts.forEach{
            val response = savePost(it)
            if(!response){
                responseFinal = false
            }
        }
        return responseFinal
    }

    override suspend fun savePost(post: PostEntity): Boolean {
        val dbHelper = LocalSqlite(context)
        return try {
            dbHelper.writableDatabase.execSQL("" +
                    "INSERT INTO ${PostSqlite.TABLE_NAME}" +
                    " (${PostSqlite.COLUMN_ID}, ${PostSqlite.COLUMN_BODY}, ${PostSqlite.COLUMN_TITLE}," +
                    " ${PostSqlite.COLUMN_USER_ID})" +
                    " VALUES (?, ?, ?, ?)",
                arrayOf(post.id, post.body, post.title, post.userId))
            true
        }catch (e: Exception){
            false
        }
    }

    private fun getFromSqlite(sql: String): List<PostEntity> {
        val dbHelper = LocalSqlite(context)
        return try {
            val posts : MutableList<PostEntity> = mutableListOf()
            dbHelper.readableDatabase.rawQuery(sql, null).use {
                val postGetted = PostLocalDto.toPost(it)
                posts.add(postGetted)
            }
            posts.toList()
        }catch (e: Exception){
            listOf()
        }
    }
}