package com.example.demo.api

sealed class ResponseSealedClass<T>(data: T? = null, exception: String? = null) {
    data class Success<T>(val data: T) : ResponseSealedClass<T>(data = data)
    data class Failure<T>(val exception: String) : ResponseSealedClass<T>(exception = exception)
}