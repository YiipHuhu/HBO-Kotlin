package com.example.hbou

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide

class FilmDetailsDialogFragment : DialogFragment() {

    private lateinit var film: Film

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        film = arguments?.getParcelable("film")!!

        view.findViewById<TextView>(R.id.textViewFilmTitle).text = film.title
        view.findViewById<TextView>(R.id.textViewFilmYear).text = film.year.toString()
        view.findViewById<TextView>(R.id.textViewFilmRating).text = "Nota: ${film.rating}"
        view.findViewById<TextView>(R.id.textViewFilmDescription).text = film.description
        Glide.with(this).load(film.imageUrl).into(view.findViewById(R.id.imageViewFilmCover))
    }

    companion object {
        fun newInstance(film: Film): FilmDetailsDialogFragment {
            val fragment = FilmDetailsDialogFragment()
            val args = Bundle()
            args.putParcelable("film", film)
            fragment.arguments = args
            return fragment
        }
    }
}
