package com.example.demo.api

sealed class NetworkResult<in T> {
    class Success<T>(val data: T) : NetworkResult<T>()
    class Failure<T>(val data: Any, val errorCode: Int) : NetworkResult<T>()
    class Exceptions<T>(val exceptionMessage: String) : NetworkResult<T>()
    class Loading<T>(val status: Boolean) : NetworkResult<T>()
}
