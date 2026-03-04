package com.saif.dpm1.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

open class FeedReaderDbHelper() : SQLiteOpenHelper(null, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(FeedReaderContract.SQL_CREATE_ENTRIES)
        print("AAAAAAAAAAAAAAAADWadawdawdAAAAAAAAAAAAAAAAAAAAA")
        print(db.getPath())
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(FeedReaderContract.SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun hacerSelect(): String? {
        return SQLiteDatabase.findEditTable(FeedReaderContract.FeedEntry.TABLE_NAME)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"
    }
}

object FeedReaderContract {
    // Table contents are grouped together in an anonymous object.
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "CONFIGAPP"
        const val COLUMN_NAME_TITLE = "referencia"
        const val COLUMN_NAME_SUBTITLE = "valor"
    }


    public const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${FeedEntry.COLUMN_NAME_TITLE} TEXT NOT NULL," +
                "${FeedEntry.COLUMN_NAME_SUBTITLE} TEXT NOT NULL)"

    public const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedEntry.TABLE_NAME}"
}

