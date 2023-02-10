package com.example.demo.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demo.databinding.ActivityTempBinding
import com.example.demo.extras.ResponseSealedClass
import com.example.demo.model.MovieResult
import com.example.demo.view.adapters.MovieAdapter
import com.example.demo.viewmodel.MovieViewModel


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTempBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityTempBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel.getPopularMovies()
        viewModel.movieLiveData.observe(this) { movieData: ResponseSealedClass<out Any> ->
            Toast.makeText(this, "Observed", Toast.LENGTH_LONG).show()
            if (movieData is ResponseSealedClass.Success) {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                movieData.data.run {
                    movieAdapter.setMovieList(movieData.data as List<MovieResult>)
                }
            } else {
                Toast.makeText(this, "Exception", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = movieAdapter
        }
    }
}