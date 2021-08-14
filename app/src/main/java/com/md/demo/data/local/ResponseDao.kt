package com.md.demo.data.local

import androidx.room.*
import com.md.demo.data.model.ResponseBean

@Dao
interface ResponseDao {

    @Query("SELECT * from responseBean")
    fun getDbList(): List<ResponseBean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(responseBean: ResponseBean)

    @Update
    fun update(responseBean: ResponseBean): Int

    @Query("DELETE FROM responseBean")
    fun deleteAll()
}