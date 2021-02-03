package com.example.app.data

import android.app.Application
import android.content.Context
import com.example.app.model.Console
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ConsoleRepository(context: Context){

    // *** Acesso ao banco de dados
    private val mDataBase = AppDataBase.getDatabase(context).consoleDao()

    // **** Carrega lista de consoles
    fun getConsoles(context: Context) : List<Console> {
        return mDataBase.getAll()
    }

    // **** Grava um novo console
    fun saveConsole(console: Console) {
        return mDataBase.insertConsole(console)
    }

}