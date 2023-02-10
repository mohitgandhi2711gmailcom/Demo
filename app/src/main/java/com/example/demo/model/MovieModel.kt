package com.example.demo.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("results")
    val results: List<MovieResult>?,
    @SerializedName("total_results")
    val totalResults: Int = 0
)