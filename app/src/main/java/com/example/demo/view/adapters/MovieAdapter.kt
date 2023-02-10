package com.example.demo.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.databinding.MovieLayoutBinding
import com.example.demo.model.MovieResult

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList: ArrayList<MovieResult>? = ArrayList()

    fun setMovieList(movieList: List<MovieResult>?) {
        if (movieList != null) {
            this.movieList = movieList as ArrayList<MovieResult>
            notifyDataSetChanged()
        }
    }

    class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + movieList!![position].posterPath)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList!![position].title
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }
}