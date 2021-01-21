package com.example.app.model

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.time.LocalDate
import java.util.*

@Entity
data class Console (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var consoleName: String,
    var maker: String,
    var releaseDate: String
)