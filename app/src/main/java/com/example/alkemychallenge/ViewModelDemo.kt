package com.example.alkemychallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

class ViewModelDemo(private val moviesUseCases: MoviesUseCases): ViewModel() {

    private val mListMovies = MutableLiveData<List<Movies>>()
    val listMovies: LiveData<List<Movies>> = mListMovies

    private val mOnError = MutableLiveData<String>()
    val onError: LiveData<String> = mOnError

    fun getPopularMovies(){
        viewModelScope.launch {
            when(val result = this@ViewModelDemo.moviesUseCases.getPopularMovies()){
                is ObjectResult.Success -> this@ViewModelDemo.mListMovies.value = result.data.results
                is ObjectResult.Failure -> this@ViewModelDemo.mOnError.value = result.exception.message
            }
        }
    }
}