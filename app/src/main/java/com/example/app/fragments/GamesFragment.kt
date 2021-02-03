package com.example.app.fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.adapter.GamesRecyclerAdapter
import com.example.app.data.GameRepository
import com.example.app.model.Game

class GamesFragment : Fragment() {

    private lateinit var gamesRecyclerView: RecyclerView
    private val gameAdapter = GamesRecyclerAdapter()
    private var gameList = listOf<Game>()

    private lateinit var buttonGameAdd: ImageButton

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
        gameList = GameRepository.getGames(context!!)
        gameAdapter.updateGameList(gameList)

        buttonGameAdd = view.findViewById(R.id.button_game_add)
        buttonGameAdd.setOnClickListener {
            Toast.makeText(context!!, "clicou!", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_new_game, menu)

    }

}