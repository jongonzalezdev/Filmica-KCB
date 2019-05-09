package com.example.jongonzalez.filmica

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: Fragment() {

    companion object {
        fun newInstance(filmId: String): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString("id", filmId)
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString("id", "")
        val film = FilmsRepo.findFilmById(id!!)

        film?.let {
            labelTitle.text = it.title
            labelDescription.text = it.overview
            labelGenre.text = it.genre
            labelDate.text = it.date
            labelRating.text = it.rating.toString()

        }

        buttonAdd.setOnClickListener {
            Toast.makeText(context, "Añadido al watchlist", Toast.LENGTH_LONG).show()
        }

    }
}