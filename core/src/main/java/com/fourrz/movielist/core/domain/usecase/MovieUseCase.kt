package com.fourrz.movielist.core.domain.usecase

import com.fourrz.movielist.core.data.source.Resource
import com.fourrz.movielist.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}