package com.example.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.holder.GameViewHolder
import com.example.app.model.Game

class GamesRecyclerAdapter : RecyclerView.Adapter<GameViewHolder>() {

    private var gamesList = listOf<Game>()

    fun updateGameList(newGameList: List<Game>) {
        this.gamesList = newGameList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.game_view_holder_layout, parent, false)

        return GameViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = gamesList[position]
        holder.bind(game)
    }
}