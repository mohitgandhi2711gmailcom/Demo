package com.example.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.api.NetworkResult
import com.example.demo.extras.ResponseSealedClass
import com.example.demo.model.MovieModel
import com.example.demo.model.MovieResult
import com.example.demo.utils.RetrofitInstance
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    var movieLiveData: MutableLiveData<ResponseSealedClass<out Any>> = MutableLiveData<ResponseSealedClass<out Any>>()

    fun getPopularMovies() {
        NetworkResult.Loading<Boolean>(true)
        viewModelScope.launch {
            movieLiveData.postValue(getMovies())
        }
    }

    private suspend fun getMovies(): ResponseSealedClass<out Any> {
        val async = viewModelScope.async {
            try {
                val resp = RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0")
                    .execute()
                return@async ResponseSealedClass.Success(resp.body()!!.results!!)
            } catch (e: Exception) {
                return@async ResponseSealedClass.Failure<String>(e.localizedMessage!!)
            }
        }
        return async.await()
    }
}
