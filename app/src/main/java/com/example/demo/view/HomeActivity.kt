package com.example.demo.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demo.api.ResponseSealedClass
import com.example.demo.database.MovieDatabase
import com.example.demo.databinding.ActivityHomeBinding
import com.example.demo.helper.DBHelper
import com.example.demo.model.MovieModel
import com.example.demo.model.MovieResult
import com.example.demo.testing.fragment_backstack.*
import com.example.demo.view.adapters.MovieAdapter
import com.example.demo.viewmodel.MovieViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        prepareRecyclerView()
//        showAPIData()
//        observeChangesInDB()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.actionBtn.setOnClickListener {
            /*lifecycleScope.launch(Dispatchers.IO) {
            val setupFlow = FlowTesting.setupFlow()
                setupFlow.collect{
                    Log.e("Mohit", "$it")
                }
            }*/

            val supportFragmentManager = supportFragmentManager
            Log.e("Mohit", "BackStack Count is ${supportFragmentManager.backStackEntryCount}")
            val beginTransaction = supportFragmentManager.beginTransaction()
            when (count) {
                5 -> {
                    beginTransaction.replace(binding.frameLayout.id, FragmentFive(), "Fragment Five")
                        .addToBackStack("Fragment Five")
                        .commit()
                }
                1 -> {
                    beginTransaction.add(binding.frameLayout.id, FragmentOne(), "Fragment One")
                        .addToBackStack("Fragment One")
                        .commit()
                    count++
                }
                2 -> {
                    beginTransaction.add(binding.frameLayout.id, FragmentTwo(), "Fragment Two")
                        .addToBackStack("Fragment Two")
                        .commit()
                    count++
                }
                3 -> {
                    beginTransaction.add(binding.frameLayout.id, FragmentThree(), "Fragment Three")
                        .addToBackStack("Fragment Three")
                        .commit()
                    count++
                }
                4 -> {
                    beginTransaction.add(binding.frameLayout.id, FragmentFour(), "Fragment Four")
                        .addToBackStack("Fragment Four")
                        .commit()
                    count++
                }
                /*else -> {
                    beginTransaction.add(binding.frameLayout.id, FragmentOne(), "Fragment One")
                        .commit()
                    count++
                }*/
            }
        }
    }

    private fun observeChangesInDB() {
        DBHelper.getMovieList(MovieDatabase.getDatabase(this@HomeActivity).movieDao())
            .observe(this) { movieData ->
                Log.e("Mohit", "Observed Data Movie List is ${movieData.size}")
            }

        DBHelper.getMainMovieModel(MovieDatabase.getDatabase(this@HomeActivity).movieDao())
            .observe(this) { movieData ->
                Log.e("Mohit", "Observed Data Main Movie is $movieData")
            }
    }

    private fun showAPIData() {
        viewModel.getPopularMovies()
        viewModel.movieLiveData.observe(this) { movieData: ResponseSealedClass<out Any> ->
            when (movieData) {
                is ResponseSealedClass.Success -> {
                    val movieModel: MovieModel = movieData.data as MovieModel
                    movieAdapter.setMovieList(movieModel.results as List<MovieResult>)
                    lifecycleScope.launch(Dispatchers.IO) {
                        DBHelper.insertMovieModel(
                            MovieDatabase.getDatabase(this@HomeActivity).movieDao(), movieModel
                        )
                        DBHelper.insertMovieList(
                            MovieDatabase.getDatabase(this@HomeActivity).movieDao(),
                            movieModel.results
                        )
                    }
                }
                is ResponseSealedClass.Failure -> Toast.makeText(
                    this,
                    movieData.exception,
                    Toast.LENGTH_LONG
                ).show()
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