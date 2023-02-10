package com.example.demo.utils

import android.util.Log
import com.example.demo.generics.Person
import com.example.demo.enum_sealed.Directions
import com.example.demo.enum_sealed.ShapeSealedClass
import com.example.demo.model.Employee

object TestingUtils {
    private fun doEnumTesting() {
        val direction = Directions.NORTH
        Log.e("Mohit", "Name is :- ${direction.name}")
        Log.e("Mohit", "Ordinal is :- ${direction.ordinal}")
        Log.e("Mohit", "String is :- $direction")
        Log.e("Mohit", "String is :- ${direction.distance}")
        Log.e("Mohit", "String is :- ${direction.doMovement()}")
        Log.e("Mohit", "String is :- ${direction.myInstructions()}")
        Log.e(
            "Mohit", "String is :- ${
                Directions.values().forEach {
                    Log.e("Mohit One", it.name)
                }
            }"
        )

        Log.e("Mohit", "String is :- ${
            enumValues<Directions>().forEach {
                Log.e("Mohit Two", it.name)
            }
        }")
    }

    private fun doSealedTesting() {
        val circleArea = ShapeSealedClass.Circle(4).getArea()
        val rectangleArea = ShapeSealedClass.Rectangle(4, 8).getArea()
        val squareArea = ShapeSealedClass.Square(4).getArea()

        Log.e("Mohit", "Circle Area is $circleArea")
        Log.e("Mohit", "Rectangle Area is $rectangleArea")
        Log.e("Mohit", "Square Area is $squareArea")
    }

    private fun doScopeTesting() {
        val employee = Employee("Shiv", 10)
        employee.apply {
            this.name = "RAMAN"
            Log.e("Mohit Apply", "Inside Scope")
        }.also {
            Log.e("Mohit Also", employee.name)
        }
    }

    private fun doGenericTesting() {
        val personOne = Person(10)
        val personTwo = Person("Mohit")
        personOne.getHistory()
        personTwo.getHistory()
        Log.e("Mohit", personOne.getHistory().toString())
        Log.e("Mohit", personTwo.getHistory().toString())
        personOne.setValue(11)
        personTwo.setValue("Gandhi")
        Log.e("Mohit", personOne.getHistory().toString())
        Log.e("Mohit", personTwo.getHistory().toString())

        val letters = ArrayList<String>()
        letters.add("A")
        letters.add("B")
    }
}