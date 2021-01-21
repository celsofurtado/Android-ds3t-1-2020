package com.example.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.data.ConsoleDataSource
import com.example.app.holder.ConsoleViewHolder
import com.example.app.model.Console

class ConsoleRecyclerAdapter : RecyclerView.Adapter<ConsoleViewHolder>() {

    private var consoleList = listOf<Console>()

    fun updateConsoleList(newConsoleList: List<Console>){
        this.consoleList = newConsoleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsoleViewHolder {

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.console_view_holder_layout, parent, false)

        return ConsoleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return consoleList.size
    }

    override fun onBindViewHolder(holder: ConsoleViewHolder, position: Int) {
        val console = consoleList[position]
        holder.bind(console)
    }
}