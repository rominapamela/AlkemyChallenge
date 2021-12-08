package com.example.alkemychallenge

import android.content.Context
import java.lang.Exception

class RemoteDataSource(context: Context): IRemoteDataSource {

    override suspend fun getPopularMovies(): ObjectResult<ResponseAppApi> {
        val appApi = MoviesApiClient.build()

        return try{
            val response = appApi.getPopularMovies()
            if (response.isSuccessful){
                val body = response.body()
                ObjectResult.Success(body?.toResponseAppApi() ?: ResponseAppApi())
            }else{
                ObjectResult.Failure(Exception(response.errorBody()?.toString()))
            }
        } catch (ex: Exception){
            ObjectResult.Failure(ex)
        }
    }
}


