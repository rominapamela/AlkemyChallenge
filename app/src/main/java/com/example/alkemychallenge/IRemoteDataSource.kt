package com.example.alkemychallenge


interface IRemoteDataSource {
    suspend fun getPopularMovies(): ObjectResult<ResponseAppApi>
}

