package com.md.demo.data.local

import android.content.Context
import androidx.room.*
import com.md.demo.data.model.UserResult

@Database(entities = [UserResult::class], version = 1, exportSchema = false)
@TypeConverters(ResConverter::class)
abstract class MyDatabase : RoomDatabase() {

        abstract fun myDao() : UserDao

        companion object {

                private var INSTANCE : MyDatabase? = null

                private val lock = Any()

                fun getInstance(context : Context) : MyDatabase {
                        synchronized(lock) {
                                if (INSTANCE == null) {
                                        INSTANCE = Room.databaseBuilder(
                                                context.applicationContext,
                                                MyDatabase::class.java, "mydb.db"
                                        )
                                                .build()
                                }
                                return INSTANCE!!
                        }
                }
        }

}