package com.example.hbou

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var filmAdapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val filmList = listOf(
            Film("Homem-Aranha: Através do Aranhaverso", "Fantasia & Ficção Científica", 2023,"https://www.sonypictures.com.br/sites/brazil/files/tittle-page/thumbnails/SN_HomemAranha_576x313.jpg"),
            Film("The Batman", "Ação/Crime", 2022, "https://blogs.uai.com.br/opipoqueiro/wp-content/uploads/sites/54/2022/02/Batman-01.jpg"),
            Film("Interstellar", "Ficção Científica", 2014,"https://i.ytimg.com/vi/YF1eYbfbH5k/hq720.jpg?sqp=-oaymwE7CK4FEIIDSFryq4qpAy0IARUAAAAAGAElAADIQj0AgKJD8AEB-AH-CYAC0AWKAgwIABABGE4gYShlMA8=&rs=AOn4CLDVzF22XzACAjhcKPejLGAtd9S7Mw"),
            Film("The Matrix", "Ficção Científica", 1999, "https://s2.glbimg.com/kH0D1eqK32a1thZ0ctmO4S64I6U=/e.glbimg.com/og/ed/f/original/2019/05/20/matrix_1999.jpg"),
            Film("Harry Potter e a Pedra Filosofal", "Infantil/Fantasia",  2001, "https://uploads.jovemnerd.com.br/wp-content/uploads/2021/11/harry-potter-e-a-pedra-filosofal-diretor-gostaria-lancamento-versao-tres-horas.jpg")
        )

        filmAdapter = FilmAdapter(filmList)
        recyclerView.adapter = filmAdapter
    }
}