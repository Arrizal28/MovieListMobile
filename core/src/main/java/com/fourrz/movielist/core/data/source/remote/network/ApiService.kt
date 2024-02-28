package com.fourrz.movielist.core.data.source.remote.network

import com.fourrz.movielist.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("discover/movie")
    suspend fun getList(): ListMovieResponse
}