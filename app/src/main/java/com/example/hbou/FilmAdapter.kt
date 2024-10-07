package com.example.hbou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FilmAdapter(private val filmList: List<Film>) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmList[position]
        holder.bind(film)

        holder.itemView.setOnClickListener {
            val fragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
            val filmDetailsDialog = FilmDetailsDialogFragment.newInstance(film)
            filmDetailsDialog.show(fragmentManager, "filmDetailsDialog")
            filmDetailsDialog.dialog?.window?.attributes?.windowAnimations = R.style.FadeInAnimation
        }
    }

    override fun getItemCount(): Int = filmList.size

    class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.textViewTitle)
        private val genre = itemView.findViewById<TextView>(R.id.textViewGenre)
        private val year = itemView.findViewById<TextView>(R.id.textViewYear)
        private val cover = itemView.findViewById<ImageView>(R.id.imageViewCover)

        fun bind(film: Film) {
            title.text = film.title
            genre.text = film.genre
            year.text = film.year.toString()
            Glide.with(itemView.context)
                .load(film.imageUrl)
                .placeholder(R.drawable.placeholder_image) // Imagem padrão enquanto carrega
                .error(R.drawable.error_image) // Imagem de erro caso falhe
                .into(cover)
        }
    }
}
