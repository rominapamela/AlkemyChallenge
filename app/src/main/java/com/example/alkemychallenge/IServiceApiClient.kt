package com.example.alkemychallenge

import retrofit2.Response
import retrofit2.http.GET

interface IServiceApiClient {
    @GET("movie/popular?api_key=bc7fa4c2bb7b32f08f1160f71b596a58")
    suspend fun getPopularMovies(): Response<ResponseApi>
}
