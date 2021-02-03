package com.example.app.data

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toDrawable
import com.example.app.R
import com.example.app.model.Console
import com.example.app.model.Game

class GameRepository {

    companion object {
        fun getGames(context: Context) : ArrayList<Game> {

            var games = ArrayList<Game>()

//            games.add(
//                Game(100, "Street Fighter II", 5.0, "Super Nintendo", "Street Fighter, popularmente abreviado para SF, é uma popular série de jogos de luta na qual o jogador controla lutadores de diversas partes do mundo.",
//                arrayListOf(
//                    Console(1, "Snes", "Nintendo", ""),
//                    Console(2, "Mega", "Tectoy", "")),
//                    context.getDrawable(R.drawable.street2)!!
//                )
//            )
//
//            games.add(
//                Game(200, "Contra 3 - The Alien Wars", 4.0, "Super Nintendo", "Contra III: Aliens Wars, é um jogo do console SNES, lançado em 1992 no Japão como Contra Spirits é o terceiro jogo da série Contra da Konami.",
//                    arrayListOf(
//                        Console(1, "Snes", "Nintendo", ""),
//                        Console(3, "PS4", "Sony", ""),
//                        Console(4, "PC", "PC", "")),
//                    context.getDrawable(R.drawable.contra3)!!
//                )
//            )
//
//            games.add(
//                Game(300, "Super Mario World", 3.5, "Super Nintendo", "Super Mario World, originalmente chamado no Japão de Super Mario Bros. 4, é um jogo de plataforma desenvolvido e publicado pela Nintendo como um título que acompanhava o console Super Nintendo Entertainment System.",
//                    arrayListOf(
//                        Console(1, "Snes", "Nintendo", "")),
//                    context.getDrawable(R.drawable.mario)!!
//                )
//            )
//
//            games.add(
//                Game(400, "Ridge Racer", 4.5, "Super Nintendo", "Ridge Racer é uma série de jogos de corridas no estilo arcade desenvolvido e publicado pela Namco, tanto para a arcade e em vários consoles para video games baseado na série real de Ridge Racer.",
//                    arrayListOf(
//                        Console(5, "PS1", "Sony", ""),
//                        Console(6, "PS2", "Sony", ""),
//                        Console(7, "X-Box", "Microsoft", "")),
//                    context.getDrawable(R.drawable.ridgeracer)!!
//                )
//            )
//
//            games.add(
//                Game(400, "Resident Evil 3", 4.5, "Super Nintendo", "Resident Evil é uma franquia de mídia que pertence à empresa de videogames Capcom. Foi criada por Shinji Mikami como uma série de jogos de survival horror, iniciada em 1996 com Resident Evil para PlayStation.",
//                    arrayListOf(
//                        Console(3, "PS4", "Sony", ""),
//                        Console(8, "X-Box One", "Microsoft", "")),
//                    context.getDrawable(R.drawable.resident3)!!
//                )
//            )

            return games

        }
    }

}