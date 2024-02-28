package com.fourrz.movielist.core.utils

import com.fourrz.movielist.core.data.source.local.entity.MovieEntity
import com.fourrz.movielist.core.data.source.remote.response.ResultsItem
import com.fourrz.movielist.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<ResultsItem>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                overview = it.overview,
                title = it.title,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                id = it.id,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                overview = it.overview,
                title = it.title,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                id = it.id,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        overview = input.overview,
        title = input.title,
        backdropPath = input.backdropPath,
        releaseDate = input.releaseDate,
        voteAverage = input.voteAverage,
        id = input.id,
        isFavorite = input.isFavorite
    )
}