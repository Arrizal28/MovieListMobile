package com.fourrz.movielist.di

import com.fourrz.movielist.core.domain.usecase.MovieUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDepedencies {
    fun movieUseCase(): MovieUseCase
}