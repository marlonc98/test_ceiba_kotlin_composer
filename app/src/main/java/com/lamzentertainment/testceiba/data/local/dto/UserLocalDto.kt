package com.lamzentertainment.testceiba.data.local.dto

import android.database.Cursor
import com.lamzentertainment.testceiba.data.local.config.tables.UserSqlite
import com.lamzentertainment.testceiba.domain.entities.UserEntity
import org.json.JSONObject

class UserLocalDto {
    companion object{
        fun toUser(it: Cursor):UserEntity{
            val idIndex = it.getColumnIndex(UserSqlite.COLUMN_ID)
            val nameIndex = it.getColumnIndex(UserSqlite.COLUMN_NAME)
            val emailIndex = it.getColumnIndex(UserSqlite.COLUMN_EMAIL)
            val phoneIndex = it.getColumnIndex(UserSqlite.COLUMN_PHONE)
               return  UserEntity(id = it.getInt(idIndex),
                    name = it.getString(nameIndex),
                    email = it.getString(emailIndex),
                    phone = it.getString(phoneIndex))
        }
    }
}