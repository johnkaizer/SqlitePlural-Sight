package com.example.sqlite_pluralsight

import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object DogsDbContract {

    object CarEntry : BaseColumns {
        const val TABLE_NAME = "cars"
        const val COLUMN_NAME = "name"
        const val COLUMN_DOM = "type"
        const val COLUMN_MANUFACTURE = "manufacture"

        const val SQL_CREATE_ENTRIES:String =
            "CREATE TABLE ${CarEntry.TABLE_NAME} (" +
                    _ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "$COLUMN_NAME TEXT NOT NULL, " +
        "$COLUMN_DOM TEXT NOT NULL, " +
        "$COLUMN_MANUFACTURE TEXT NOT NULL)"

        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}