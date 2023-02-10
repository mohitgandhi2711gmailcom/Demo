package com.example.demo.enum_sealed

import android.util.Log

enum class Directions(val distance: Int, val count: Int? = null) : Instructions {
    EAST(5, 23) {
        override fun doMovement() {
            Log.e("Mohit", "Do EAST Movement")
        }

        override fun toString(): String {
            return "This is EAST Direction"
        }

        override fun myInstructions() {
            Log.e("Mohit", "This Instructions is for EAST Directions")
        }
    },
    WEST(10) {
        override fun doMovement() {
            Log.e("Mohit", "Do WEST Movement")
        }
    },
    NORTH(7) {
        override fun doMovement() {
            Log.e("Mohit", "Do NORTH Movement")
        }

        override fun toString(): String {
            return "This is NORTH Direction"
        }

        override fun myInstructions() {
            Log.e("Mohit", "This Instructions is for NORTH Directions")
        }
    },
    SOUTH(13) {
        override fun doMovement() {
            Log.e("Mohit", "Do SOUTH Movement")
        }
    };

    abstract fun doMovement()

    override fun myInstructions() {
        Log.e("Mohit", "This is common Instructions for all Directions")
    }
}