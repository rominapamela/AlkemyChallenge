package com.example.alkemychallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val moviesUseCases: MoviesUseCases): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ViewModelDemo(moviesUseCases) as T
}