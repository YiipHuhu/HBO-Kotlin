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
            Film("Homem-Aranha: Através do Aranhaverso", "Fantasia & Ficção Científica", 2023, 4.0, "Depois de se reunir com Gwen Stacy, Homem-Aranha é jogado no multiverso. Lá, o super-herói aracnídeo encontra uma numerosa equipe encarregada de proteger sua própria existência.","https://www.sonypictures.com.br/sites/brazil/files/tittle-page/thumbnails/SN_HomemAranha_576x313.jpg"),
            Film("The Batman", "Ação/Crime", 2022,4.0, "Após dois anos espreitando as ruas como Batman, Bruce Wayne se encontra nas profundezas mais sombrias de Gotham City. Com poucos aliados confiáveis, o vigilante solitário se estabelece como a personificação da vingança para a população.", "https://blogs.uai.com.br/opipoqueiro/wp-content/uploads/sites/54/2022/02/Batman-01.jpg"),
            Film("Interstellar", "Ficção Científica", 2014,4.0, "As reservas naturais da Terra estão chegando ao fim e um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial, possibilitando a continuação da espécie. Cooper é chamado " +
                    "para liderar o grupo e aceita a missão sabendo que pode nunca mais ver os filhos. Ao lado de Brand, Jenkins e Doyle, ele seguirá em busca de um novo lar.","https://i.ytimg.com/vi/YF1eYbfbH5k/hq720.jpg?sqp=-oaymwE7CK4FEIIDSFryq4qpAy0IARUAAAAAGAElAADIQj0AgKJD8AEB-AH-CYAC0AWKAgwIABABGE4gYShlMA8=&rs=AOn4CLDVzF22XzACAjhcKPejLGAtd9S7Mw"),
            Film("The Matrix", "Ficção Científica", 1999,4.0, "O jovem programador Thomas Anderson é atormentado por estranhos pesadelos em que está sempre conectado por cabos a um imenso sistema de computadores do futuro. À medida que o sonho se repete, ele começa a desconfiar da " +
                    "realidade. Thomas conhece os misteriosos Morpheus e Trinity e descobre que é vítima de um sistema inteligente e artificial chamado Matrix, que manipula a mente das pessoas e cria a ilusão de um mundo real enquanto usa os cérebros e corpos dos indivíduos para produzir energia.", "https://s2.glbimg.com/kH0D1eqK32a1thZ0ctmO4S64I6U=/e.glbimg.com/og/ed/f/original/2019/05/20/matrix_1999.jpg"),
            Film("Harry Potter e a Pedra Filosofal", "Infantil/Fantasia",  2001,4.0, "Harry Potter é um garoto órfão que vive infeliz com seus tios, os Dursleys. Ele recebe uma carta contendo um convite para ingressar em Hogwarts, uma famosa escola especializada em formar jovens bruxos." +
                    " Inicialmente, Harry é impedido de ler a carta por seu tio, mas logo recebe a visita de Hagrid, o guarda-caça de Hogwarts, que chega para levá-lo até a escola. Harry adentra um mundo mágico que jamais imaginara, vivendo diversas aventuras com seus novos amigos, Rony Weasley e Hermione Granger.", "https://uploads.jovemnerd.com.br/wp-content/uploads/2021/11/harry-potter-e-a-pedra-filosofal-diretor-gostaria-lancamento-versao-tres-horas.jpg")
        )

        filmAdapter = FilmAdapter(filmList)
        recyclerView.adapter = filmAdapter
    }
}