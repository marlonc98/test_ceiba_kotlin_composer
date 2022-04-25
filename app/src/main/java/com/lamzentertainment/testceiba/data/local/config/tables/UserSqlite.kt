package com.lamzentertainment.testceiba.data.local.config.tables

import android.content.Context
import com.google.gson.Gson
import com.lamzentertainment.testceiba.data.local.config.LocalSqlite
import org.json.JSONArray
import org.json.JSONObject

class UserSqlite(private val context: Context) {
    companion object{
        const val TABLE_NAME = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PHONE = "phone"
        fun create ():String {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    " $COLUMN_ID INTEGER PRIMARY KEY," +
                    " $COLUMN_NAME TEXT," +
                    " $COLUMN_EMAIL TEXT," +
                    " $COLUMN_PHONE TEXT"
        }
    }
}