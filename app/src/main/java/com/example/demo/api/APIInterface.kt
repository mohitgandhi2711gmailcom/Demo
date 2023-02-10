package com.example.demo.api

import com.example.demo.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<MovieModel>

}