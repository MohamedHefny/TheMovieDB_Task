package com.mohamedhefny.aqarmaptask.data.remote

import com.mohamedhefny.aqarmaptask.BuildConfig
import com.mohamedhefny.aqarmaptask.data.models.Movie
import com.mohamedhefny.aqarmaptask.data.remote.response.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("{sortBy}")
    suspend fun getMovies(
        @Path("sortBy") sortBy: String = "popular",
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    )
            : Response<List<Movie>>

}