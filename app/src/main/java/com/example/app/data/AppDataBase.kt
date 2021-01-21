package com.example.app.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.app.data.dao.ConsoleDao
import com.example.app.model.Console

@Database(entities = [Console::class], version = 8)
abstract class AppDataBase : RoomDatabase() {

    companion object {

        @JvmField
        val MIGRATION_5_6 = Migration5To6()

//        @JvmField
//        val MIGRATION_6_7 = Migration6To7()

        fun get(application: Application) : AppDataBase {

//            return Room.databaseBuilder(application, AppDataBase::class.java, "games")
//                .addMigrations(MIGRATION_6_7)
//                .build()

            return Room.databaseBuilder(application, AppDataBase::class.java, "games")
                .fallbackToDestructiveMigration()
                .build()
        }


    }

    abstract fun consoleDao() : ConsoleDao

}

class Migration5To6 : Migration(5, 6) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Criar uma nova coluna na tabela console
        database.execSQL("ALTER TABLE Console ADD COLUMN teste TEXT NOT NULL DEFAULT ''")
    }
}

class Migration6To7 : Migration(6, 7) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Criar uma nova coluna na tabela console
        database.execSQL("ALTER TABLE Console ADD COLUMN teste2 TEXT NOT NULL DEFAULT '7'")
    }
}

class Migration7To8 : Migration(7, 8) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Criar uma nova coluna na tabela console
        database.execSQL("ALTER TABLE Console ADD COLUMN teste2 TEXT NOT NULL DEFAULT '7'")
    }
}