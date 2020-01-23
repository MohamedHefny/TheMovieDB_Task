package com.mohamedhefny.aqarmaptask.ui.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mohamedhefny.aqarmaptask.R
import com.mohamedhefny.aqarmaptask.data.models.Movie
import kotlinx.android.synthetic.main.layout_movie_details.*

class MovieDetailsDialog : DialogFragment() {

    private lateinit var movie: Movie

    override fun onStart() {
        super.onStart()
        dialog?.window?.attributes?.windowAnimations = R.style.DialogAnimation
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_movie_details, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindMovieDetails(movie)
    }

    private fun bindMovieDetails(movie: Movie) {
        movie_title.text = movie.title
        movie_overview.text = movie.overview
    }

    fun setMovieDetails(movie: Movie) {
        this.movie = movie
    }
}