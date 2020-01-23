package com.mohamedhefny.aqarmaptask.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamedhefny.aqarmaptask.data.models.Movie
import com.mohamedhefny.aqarmaptask.data.remote.ApiClient
import com.mohamedhefny.aqarmaptask.data.remote.ApiService
import com.mohamedhefny.aqarmaptask.data.remote.response.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _moviesList by lazy { MutableLiveData<List<Movie>>() }
    val moviesList by lazy { _moviesList }

    //TODO: Use repository pattern
    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies: Response<List<Movie>> = ApiClient.getApiClient<ApiService>().getMovies()
            _moviesList.postValue(movies.results)
        }
    }
}