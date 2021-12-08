package com.example.alkemychallenge

interface IRemoteRepository {
    suspend fun getPopularMovies(): ObjectResult<ResponseAppApi>
}