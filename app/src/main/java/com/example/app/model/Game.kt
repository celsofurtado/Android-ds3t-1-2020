package com.example.app.model

import android.graphics.drawable.Drawable

data class Game (
    var codigo: Int,
    var name: String,
    var rate: Double,
    var console: String,
    var description: String = "Resident Evil 3, chamado no Japão de Biohazard RE:3, é um jogo eletrônico de survival horror desenvolvido e publicado pela Capcom.",
    var consoles: List<Console>,
    var gameImage: Drawable
)