package com.fourrz.movielist.favorite

import android.content.Context
import com.fourrz.movielist.di.FavoriteModuleDepedencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDepedencies::class])
interface FavoriteComponent {


    fun inject(activity: FavoriteActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDepedencies): Builder
        fun build(): FavoriteComponent
    }
}