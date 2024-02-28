package com.fourrz.movielist.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.fourrz.movielist.R
import com.fourrz.movielist.core.domain.model.Movie
import com.fourrz.movielist.databinding.ActivityDetailMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.round
import kotlin.math.roundToInt

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModels()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMovie = getParcelableExtra(intent, EXTRA_DATA, Movie::class.java)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            binding.content.tvReleaseDateTitle.text = getString(R.string.release_date)
            binding.content.tvReleaseDate.text = detailMovie.releaseDate
            binding.content.tvRatingTitle.text = getString(R.string.rating)
            binding.content.tvRating.text = roundRating(detailMovie.voteAverage).toString()
            binding.content.tvDescriptionTitle.text = getString(R.string.overview)
            binding.content.tvDetailDescription.text = detailMovie.overview
            binding.ivDetailImage.load(getString(R.string.image_url, detailMovie.backdropPath))

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }

    private fun roundRating(rating: Double): Double {
        return round(rating * 10.0) / 10.0
    }
}