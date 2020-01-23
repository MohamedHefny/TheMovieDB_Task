package com.mohamedhefny.aqarmaptask.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohamedhefny.aqarmaptask.R
import com.mohamedhefny.aqarmaptask.data.models.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(private val moviesList: List<Movie>, private var movieCallback: MovieCallback) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(movieView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovieData(moviesList[position])
        holder.itemView.setOnClickListener { movieCallback.onMovieClicked(moviesList[position]) }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val BASE_POSTER_URL = "http://image.tmdb.org/t/p/w185"
        private val moviePoster: ImageView = itemView.item_movie_poster
        private val movieTitle: TextView = itemView.item_movie_title

        fun bindMovieData(movie: Movie) {
            movieTitle.text = movie.title
            Picasso.get()
                .load(BASE_POSTER_URL.plus(movie.poster_path))
                .into(moviePoster)
        }
    }

    interface MovieCallback {
        fun onMovieClicked(movie: Movie)
    }
}