package com.example.alkemychallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.alkemychallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<ViewModelDemo>{
        val remoteRepository = RemoteRepository(RemoteDataSource(this))
        ViewModelFactory(MoviesUseCases(remoteRepository))
    }

    private val adapter: MoviesAdapter by lazy { MoviesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        bind()
        callViewModelMethods()
        //onClickEvents()
        initRecycler()
        viewModelObservers()
    }


    private fun bind(){
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
    }

    private fun callViewModelMethods(){
        this.viewModel.getPopularMovies()
    }
    private fun viewModelObservers(){

        this.viewModel.onError.observe(this,{
            //lo que debe hacer si es que detecta algun error
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        this.viewModel.listMovies.observe(this, {
            this.adapter.list = it
        })
    }

    private fun initRecycler(){
        this.binding.rvMovies.adapter = this.adapter

        this.adapter.movieClick = {
            val intent = Intent(this@MainActivity,DetailsActivity::class.java);
            intent.putExtra("popularity", it.popularity)
            intent.putExtra("date", it.realise)
            intent.putExtra("overview", it.overview)
            intent.putExtra("title", it.title)
            startActivity(intent);
        }
    }
}