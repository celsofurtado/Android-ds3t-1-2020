package com.example.app.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.adapter.GamesRecyclerAdapter
import com.example.app.data.DataSource
import com.example.app.model.Game
import kotlinx.android.synthetic.main.fragment_games.*

class GamesFragment : Fragment() {

    private lateinit var gamesRecyclerView: RecyclerView
    private val gameAdapter = GamesRecyclerAdapter()
    private var gameList = listOf<Game>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_games, container, false)
        setHasOptionsMenu(true) // Isso que vai permitir colocar o menu na toolbar do fragment

        gamesRecyclerView = view.findViewById(R.id.recycler_view_jogos)
        gamesRecyclerView.layoutManager = LinearLayoutManager(view.context)
        gamesRecyclerView.adapter = gameAdapter
        gameList = DataSource.getGames(context!!)
        gameAdapter.updateGameList(gameList)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Definindo a toolbar do fragment
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Games"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_new_game, menu)

    }

}