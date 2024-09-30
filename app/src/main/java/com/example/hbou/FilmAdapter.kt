package com.example.hbou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FilmAdapter(private val filmList: List<Film>) :
    RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.textViewTitle)
        val genreTextView: TextView = view.findViewById(R.id.textViewGenre)
        val yearTextView: TextView = view.findViewById(R.id.textViewYear)
        val coverImageView = view.findViewById<ImageView>(R.id.imageViewCover)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmList[position]
        holder.titleTextView.text = film.title
        holder.genreTextView.text = film.genre
        holder.yearTextView.text = film.year.toString()

        // Carregar a imagem de capa usando Glide
        Glide.with(holder.itemView.context)
            .load(film.imageUrl) // URL da imagem
            .placeholder(R.drawable.placeholder_image) // Imagem padrão enquanto carrega
            .error(R.drawable.error_image) // Imagem de erro caso falhe
            .into(holder.coverImageView) // Insere a imagem no ImageView
    }

    override fun getItemCount() = filmList.size
}
