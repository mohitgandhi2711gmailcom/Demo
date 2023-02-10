package com.example.demo.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.demo.model.MovieModel
import com.example.demo.model.MovieResult

@Dao
interface MovieDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertMovieResult(movieResult: MovieResult)

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertMovieModel(movieModel: MovieModel)

    @Update
    fun update(movieResult: MovieResult)

    @Delete
    fun delete(movieResult: MovieResult)

    @Query("SELECT * FROM movie_results")
    fun getAllMoviesList(): LiveData<List<MovieResult>>

    @Query("SELECT * FROM main_movie")
    fun getMovieModel(): LiveData<MovieModel>

}