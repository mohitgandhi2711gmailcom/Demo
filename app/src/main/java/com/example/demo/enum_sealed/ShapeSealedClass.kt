package com.example.demo.enum_sealed

sealed class ShapeSealedClass {
    class Circle(private var radius: Int) : ShapeSealedClass() {
        override fun getArea(): Int {
            return ((22 * radius * radius) / 7)
        }
    }

    class Rectangle(private var length: Int, private var breadth: Int) : ShapeSealedClass() {
        override fun getArea(): Int {
            return length * breadth
        }
    }

    class Square(private var side: Int) : ShapeSealedClass() {
        override fun getArea(): Int {
            return side * side
        }
    }

    abstract fun getArea(): Int
}
