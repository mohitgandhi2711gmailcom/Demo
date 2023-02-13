package com.example.demo.testing.flow

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object FlowTesting {

    suspend fun setupFlow(): Flow<Int> {
        return flow {
            Log.d("Mohit", "Start flow")
            (0..100 step 4).forEach {
                delay(500)
                Log.d("Mohit", "Emitting $it")
                emit(it)
            }
        }.flowOn(Dispatchers.Main)
    }
}