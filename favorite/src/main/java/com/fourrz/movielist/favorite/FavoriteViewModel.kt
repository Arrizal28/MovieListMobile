package com.fourrz.movielist.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fourrz.movielist.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}