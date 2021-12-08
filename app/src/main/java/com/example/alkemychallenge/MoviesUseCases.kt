package com.example.alkemychallenge

class MoviesUseCases(val remoteRepository: RemoteRepository) {
    suspend fun getPopularMovies(): ObjectResult<ResponseAppApi> = this.remoteRepository.getPopularMovies()
}