package com.example.app.data.dao

import androidx.room.*
import com.example.app.model.Console

@Dao
interface ConsoleDao {

    @Insert
    fun insertConsole(console: Console)

    @Update
    fun updateConsole(console: Console)

    @Delete
    fun deleteConsole(console: Console)

    @Query("SELECT * FROM console ORDER BY consoleName ASC")
    fun getAll(): List<Console>

    @Query("SELECT * FROM console WHERE id = :id")
    fun get(id: Int) : Console


}