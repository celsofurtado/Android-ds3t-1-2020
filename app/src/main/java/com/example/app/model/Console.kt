package com.example.app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Console {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var consoleName: String = ""
    var maker: String = ""
    var releaseDate: String = ""

}
//data class Console (
//    @PrimaryKey(autoGenerate = true)
//    var id: Int = 0,
//    var consoleName: String,
//    var maker: String,
//    var releaseDate: String
//)