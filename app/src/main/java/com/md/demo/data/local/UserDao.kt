package com.md.demo.data.local

import androidx.room.*
import com.md.demo.data.model.UserResult

@Dao
interface UserDao {
        @Query("SELECT * from userBean")
        fun getDbList() : List<UserResult>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(responseBean : UserResult)

        @Update
        fun update(responseBean : UserResult) : Int

        @Query("DELETE FROM userBean")
        fun deleteAll()

        @Query("SELECT COUNT() FROM userBean")
        fun getCount() : Int
}