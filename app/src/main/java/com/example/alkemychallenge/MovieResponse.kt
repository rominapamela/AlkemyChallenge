package com.example.alkemychallenge

data class ResponseApi(val results: List<MovieResponse>)
data class MovieResponse(val id: String, val overview:String, val original_title: String, val popularity: String, val release_date: String)
//val id: String, val title: String , val popularity: String, val realise: String


fun ResponseApi.toResponseAppApi(): ResponseAppApi = ResponseAppApi(this.results.toMoviesList())
fun List<MovieResponse>.toMoviesList(): List<Movies> = this.map {
    Movies(it.id, it.overview, it.original_title, it.popularity, it.release_date)
}

