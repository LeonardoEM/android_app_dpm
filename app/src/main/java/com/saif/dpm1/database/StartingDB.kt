package com.saif.dpm1.database

import android.provider.BaseColumns

object FeedReaderContract {
    // Table contents are grouped together in an anonymous object.
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "CONFIGAPP"
        const val COLUMN_NAME_TITLE = "referencia"
        const val COLUMN_NAME_SUBTITLE = "valor"
    }


    private const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${FeedEntry.COLUMN_NAME_TITLE} TEXT NOT NULL," +
                "${FeedEntry.COLUMN_NAME_SUBTITLE} TEXT NOT NULL)"

    private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedEntry.TABLE_NAME}"
}

