package com.mohamedhefny.aqarmaptask.data.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") var movieId: Int,
    var title: String, var overview: String,
    var popularity: Float, var vote_count: Int,
    var video: Boolean, var poster_path: String
)