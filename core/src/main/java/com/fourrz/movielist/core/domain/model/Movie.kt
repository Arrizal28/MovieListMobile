package com.fourrz.movielist.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie (
    val id: Int,
    val title: String,
    val overview: String,
    val backdropPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val isFavorite: Boolean,
) : Parcelable