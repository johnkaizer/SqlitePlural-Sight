package com.example.sqlite_pluralsight

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
      db?.execSQL(DogsDbContract.CarEntry.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(DogsDbContract.CarEntry.SQL_DROP_TABLE)
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "cars.db"
        const val DATABASE_VERSION = 1
    }
}