package com.example.app.data

import android.content.Context
import com.example.app.model.Console

class ConsoleDataSource {

    companion object {
        fun getConsoles(context: Context) : ArrayList<Console> {
            var consoles = ArrayList<Console>()

            consoles = arrayListOf(
                Console(1, "Snes", "Nintendo", "1990-05-15"),
                Console(2, "Mega Drive", "Sega", "1989-06-21"),
                Console(3, "PlayStation 1", "Sony", "1994-12-09"),
                Console(3, "PlayStation 1", "Sony", "1994-12-09"),
                Console(3, "PlayStation 1", "Sony", "1994-12-09"),
                Console(3, "PlayStation 1", "Sony", "1994-12-09"),
                Console(3, "PlayStation 1", "Sony", "1994-12-09"),
                Console(3, "PlayStation 1", "Sony", "1994-12-09"),
                Console(3, "PlayStation 1", "Sony", "1994-12-09")
            )

            return consoles
        }
    }

}