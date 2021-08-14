package com.md.demo.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.md.demo.data.model.ResponseBean

@Database(entities = arrayOf(ResponseBean::class), version = 2, exportSchema = false)
@TypeConverters(ResConverter::class)
abstract class MyDatabase : RoomDatabase() {

    abstract fun myDao(): ResponseDao

    companion object {

        private var INSTANCE: MyDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): MyDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            MyDatabase::class.java, "response.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }

}