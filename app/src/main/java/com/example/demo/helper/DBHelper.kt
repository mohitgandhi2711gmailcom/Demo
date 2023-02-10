package com.example.demo.helper

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.demo.database.MovieDao
import com.example.demo.model.MovieModel
import com.example.demo.model.MovieResult

object DBHelper {

    fun insertMovieList(movieDao: MovieDao, movieList: List<MovieResult>) {
        for (element in movieList) {
            Log.e("Mohit", "Element inserted is ${element.title}")
            movieDao.insertMovieResult(element)
        }
    }

    fun insertMovieModel(movieDao: MovieDao, movieModel: MovieModel) {
        Log.e("Mohit", "Element inserted is ${movieModel.totalPages}")
        movieDao.insertMovieModel(movieModel)
    }

    fun getMovieList(movieDao: MovieDao): LiveData<List<MovieResult>> {
        return movieDao.getAllMoviesList()
    }

    fun getMainMovieModel(movieDao: MovieDao): LiveData<MovieModel> {
        return movieDao.getMovieModel()
    }
}