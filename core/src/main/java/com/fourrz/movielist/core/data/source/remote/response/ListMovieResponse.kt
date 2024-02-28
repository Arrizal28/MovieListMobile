package com.fourrz.movielist.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
	@field:SerializedName("results")
	val results: List<ResultsItem>,
)

data class ResultsItem(

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("release_date")
	val releaseDate: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("id")
	val id: Int,
)
