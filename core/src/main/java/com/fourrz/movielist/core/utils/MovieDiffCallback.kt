package com.fourrz.movielist.core.utils

import android.annotation.SuppressLint
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.fourrz.movielist.core.domain.model.Movie

class MovieDiffCallback(private val oldList: List<Movie>, private val newList: List<Movie>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_,
            title,
            overview,
            backdropPath,
            releaseDate,
            voteAverage,
            isFavorite) = oldList[oldItemPosition]
        val (_,
            title1,
            overview1,
            backdropPath1,
            releaseDate1,
            voteAverage1,
            isFavorite1) = newList[newItemPosition]

        return title == title1
                && overview == overview1
                && backdropPath == backdropPath1
                && releaseDate == releaseDate1
                && voteAverage == voteAverage1
                && isFavorite == isFavorite1
    }

    @SuppressLint("KotlinNullnessAnnotation")
    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}