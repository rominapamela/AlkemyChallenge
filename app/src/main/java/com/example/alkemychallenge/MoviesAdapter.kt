package com.example.alkemychallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkemychallenge.databinding.ItemRecyclerBinding

typealias MovieClick = (movies: Movies) -> Unit
class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    var list: List<Movies> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var movieClick: MovieClick ?= null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MoviesViewHolder = MoviesViewHolder(
        ItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesViewHolder, position: Int) {
        holder.bind(this.list[position])
    }

    override fun getItemCount(): Int = this.list.size

    inner class MoviesViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies) {
            binding.apply {
                this.tvName.text = movies.title
                this.btnMovie.setOnClickListener {
                    this@MoviesAdapter.movieClick?.let {
                        it(movies)
                    }
                }
            }
        }
    }
}
