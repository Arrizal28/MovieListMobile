package com.fourrz.movielist.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.fourrz.movielist.core.R
import com.fourrz.movielist.core.databinding.ItemListMovieBinding
import java.util.ArrayList
import com.fourrz.movielist.core.domain.model.Movie
import com.fourrz.movielist.core.utils.MovieDiffCallback
import kotlin.math.round

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
//        val diffUtilCallback = MovieDiffCallback(listData, newListData)
//        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        listData.clear()
        listData.addAll(newListData)
//        diffResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        fun bind(data: Movie) {
            with(binding) {
                ivItemImage.load(itemView.context.getString(R.string.image_url, data.backdropPath)) {
                }
                tvItemTitle.text = data.title
                tvItemSubtitle.text = roundRating(data.voteAverage).toString()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    private fun roundRating(rating: Double): Double {
        return round(rating * 10.0) / 10.0
    }
}