package com.lamzentertainment.testceiba.data.local.dto

import android.database.Cursor
import com.lamzentertainment.testceiba.data.local.config.tables.PostSqlite
import com.lamzentertainment.testceiba.data.remote.dto.post.PostApiDto
import com.lamzentertainment.testceiba.domain.entities.PostEntity
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import org.json.JSONObject

class PostLocalDto {
    companion object {
        fun toPost(it: Cursor): PostEntity {
            // index of the columns
            val idIndex = it.getColumnIndex(PostSqlite.COLUMN_ID)
            val userIdIndex = it.getColumnIndex(PostSqlite.COLUMN_USER_ID)
            val titleIndex = it.getColumnIndex(PostSqlite.COLUMN_TITLE)
            val bodyIndex = it.getColumnIndex(PostSqlite.COLUMN_BODY)
            return PostEntity(id =  it.getInt(idIndex),
                userId = it.getInt(userIdIndex),
                title = it.getString(titleIndex),
                body = it.getString(bodyIndex))
        }
    }
}
