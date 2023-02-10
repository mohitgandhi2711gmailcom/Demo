package com.example.demo.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demo.api.Person
import com.example.demo.databinding.ActivityTempBinding
import com.example.demo.extras.Directions
import com.example.demo.extras.ResponseSealedClass
import com.example.demo.extras.ShapeSealedClass
import com.example.demo.model.Employee
import com.example.demo.model.MovieResult
import com.example.demo.view.adapters.MovieAdapter
import com.example.demo.viewmodel.MovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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
            /*movieList.run {
                mov
                movieAdapter.setMovieList(movieList)
            }*/
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