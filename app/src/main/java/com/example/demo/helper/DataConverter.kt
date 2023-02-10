package com.example.demo.helper

import androidx.room.TypeConverter
import com.example.demo.model.MovieResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class DataConverter {
    @TypeConverter
    fun fromGenreIDList(genreList: List<Int?>?): String? {
        if (genreList == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Int?>?>() {}.type
        return gson.toJson(genreList, type)
    }

    @TypeConverter
    fun toGenreIDList(countryLangString: String?): List<Int>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Int?>?>() {}.type
        return gson.fromJson<List<Int>>(countryLangString, type)
    }

    @TypeConverter
    fun fromMovieResultList(movieResult: List<MovieResult?>?): String? {
        if (movieResult == null) {
            return null
        }
        val gson = Gson()
        val type =
            object : TypeToken<List<MovieResult?>?>() {}.type
        return gson.toJson(movieResult, type)
    }

    @TypeConverter
    fun toMovieResultList(movieResultString: String?): List<MovieResult>? {
        if (movieResultString == null) {
            return null
        }
        val gson = Gson()
        val type =
            object : TypeToken<List<MovieResult?>?>() {}.type
        return gson.fromJson<List<MovieResult>>(movieResultString, type)
    }
}