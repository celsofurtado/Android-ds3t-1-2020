package com.example.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.app.model.Console

@Dao
interface ConsoleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertConsole(list: List<Console>)

    @Query("SELECT * FROM console")
    fun getAll(): List<Console>

//    @Insert
//    fun insertAll(vararg consoles: Console)

}