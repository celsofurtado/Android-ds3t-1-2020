package com.example.app.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.app.model.Console
import kotlinx.android.synthetic.main.console_view_holder_layout.view.*

class ConsoleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var textConsoleName = itemView.text_view_console_name
    private var textConsoleMaker = itemView.text_view_console_maker_name
    private var textConsoleReleaseDate = itemView.text_view_console_release_date

    fun bind(console: Console) {
        textConsoleName.text = console.consoleName
        textConsoleMaker.text = console.maker
        textConsoleReleaseDate.text = console.releaseDate
    }


}