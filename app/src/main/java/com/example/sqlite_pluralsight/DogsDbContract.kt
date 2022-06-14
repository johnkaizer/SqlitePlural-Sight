package com.example.sqlite_pluralsight

import android.provider.BaseColumns

object DogsDbContract {
    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${CarEntry.TABLE_NAME} (" +
                "${CarEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${CarEntry.COLUMN_NAME} TEXT NOT NULL, " +
                "${CarEntry.COLUMN_TYPE} TEXT NOT NULL, " +
                "${CarEntry.COLUMN_MANUFACTURE} TEXT NOT NULL)"

    const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS ${CarEntry.TABLE_NAME}"

    object CarEntry : BaseColumns {
        const val TABLE_NAME = "cars"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_TYPE = "type"
        const val COLUMN_MANUFACTURE = "manufacture"
    }
}