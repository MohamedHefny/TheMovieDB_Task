package com.mohamedhefny.aqarmaptask.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mohamedhefny.aqarmaptask.R
import com.mohamedhefny.aqarmaptask.data.models.Movie
import com.mohamedhefny.aqarmaptask.ui.movieDetails.MovieDetailsDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MoviesAdapter.MovieCallback {

    private val homeViewModel: HomeViewModel by
    lazy { ViewModelProviders.of(this).get(HomeViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeMovies()

        homeViewModel.getMovies()
    }

    private fun observeMovies() {
        homeViewModel.moviesList.observe(this, Observer {
            home_loading.visibility = View.GONE
            main_movies_recycler.adapter = MoviesAdapter(it, this)
        })
    }

    override fun onMovieClicked(movie: Movie) {
        MovieDetailsDialog().apply {
            this.setMovieDetails(movie)
            show(supportFragmentManager, "MovieDetails")
        }
    }
}
