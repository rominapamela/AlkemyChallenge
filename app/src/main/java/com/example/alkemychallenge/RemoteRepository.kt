package com.example.alkemychallenge

import com.example.alkemychallenge.IRemoteDataSource
import com.example.alkemychallenge.IRemoteRepository
import com.example.alkemychallenge.ObjectResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.alkemychallenge.ResponseAppApi

class RemoteRepository(val remoteDataSource: IRemoteDataSource): IRemoteRepository {
    override suspend fun getPopularMovies(): ObjectResult<ResponseAppApi> = withContext(Dispatchers.IO){
        when(val result = this@RemoteRepository.remoteDataSource.getPopularMovies()){
            is ObjectResult.Success -> ObjectResult.Success(result.data)
            is ObjectResult.Failure -> ObjectResult.Failure(result.exception)
        }
    }
}