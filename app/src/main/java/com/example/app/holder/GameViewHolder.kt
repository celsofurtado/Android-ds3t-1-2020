package com.example.app.holder

import android.view.View
import androidx.appcompat.view.ContextThemeWrapper
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.model.Game
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.game_view_holder_layout.view.*

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var textViewGameName = itemView.text_view_game_name
    private var textViewDescription = itemView.text_view_description
    private var chipGroupConsoles = itemView.chip_group_consoles
    private var gameRating = itemView.game_rating
    private var gameImage = itemView.image

    fun bind(game: Game) {
        textViewGameName.text = game.name
        gameRating.rating = game.rate.toFloat()
        textViewDescription.text = game.description
        gameImage.setImageDrawable(game.gameImage)

        for (console in game.consoles) {
            val chip = Chip(ContextThemeWrapper(itemView.context, R.style.ChipTextAppearance), null, 0)
            chip.text = console.consoleName
            chip.setTextAppearance(R.style.ChipTextAppearance)
            chipGroupConsoles.addView(chip)
        }

    }

}