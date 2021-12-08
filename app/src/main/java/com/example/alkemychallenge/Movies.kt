package com.example.alkemychallenge

data class ResponseAppApi(val results: List<Movies> ?= emptyList())
data class Movies ( val id: String, val overview:String, val title: String , val popularity: String, val realise: String)