package com.example.demo.utils

import com.example.demo.api.APIInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : APIInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(APIInterface::class.java)
    }
}