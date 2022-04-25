package com.lamzentertainment.testceiba.data.local.config.tables

import android.content.Context
import com.google.gson.Gson
import com.lamzentertainment.testceiba.data.local.config.LocalSqlite
import org.json.JSONArray
import org.json.JSONObject

class PostSqlite(private val context: Context) {
    companion object{
        const val TABLE_NAME = "posts"
        const val COLUMN_ID = "id"
        const val COLUMN_USER_ID = "user_id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_BODY = "body"
        fun create ():String {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    " $COLUMN_ID INTEGER PRIMARY KEY," +
                    " $COLUMN_USER_ID INTEGER," +
                    " $COLUMN_TITLE TEXT," +
                    " $COLUMN_BODY TEXT," +
                    " FOREIGN KEY ($COLUMN_USER_ID) REFERENCES ${UserSqlite.TABLE_NAME}(${UserSqlite.COLUMN_ID}))"
        }
    }

}