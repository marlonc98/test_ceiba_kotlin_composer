package com.lamzentertainment.testceiba.data.local.config
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.lamzentertainment.testceiba.data.local.config.tables.PostSqlite
import com.lamzentertainment.testceiba.data.local.config.tables.UserSqlite

class LocalSqlite(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        const val DATABASE_NAME = "text_ceiba.db"
        const val DATABASE_VERSION = 2
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(UserSqlite.create())
        sqLiteDatabase.execSQL(PostSqlite.create())
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, p1: Int, p2: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ${UserSqlite.TABLE_NAME}")
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ${PostSqlite.TABLE_NAME}")
        onCreate(sqLiteDatabase)
    }
}