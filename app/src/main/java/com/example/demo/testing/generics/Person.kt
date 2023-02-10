package com.example.demo.testing.generics

class Person<T>(private var value: T?) {

    private var history: List<T?> = listOf(value)

    fun setValue(value: T) {
        this.value = value
        this.history += value
    }

    fun getCurrentValue(): T? = value

    fun getHistory(): List<T?> = history
}