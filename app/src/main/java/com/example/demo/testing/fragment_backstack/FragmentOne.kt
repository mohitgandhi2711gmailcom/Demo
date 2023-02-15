package com.example.demo.testing.fragment_backstack

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demo.R

class FragmentOne:Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Mohit", "onAttach Method -------Fragment One-------")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Mohit", "onCreateView Method -------Fragment One-------")
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Mohit", "onCreate Method -------Fragment One-------")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Mohit", "onViewCreated Method -------Fragment One-------")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Mohit", "onStart Method -------Fragment One-------")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("Mohit", "onViewStateRestored Method -------Fragment One-------")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Mohit", "onResume Method -------Fragment One-------")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Mohit", "onPause Method -------Fragment One-------")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Mohit", "onStop Method -------Fragment One-------")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("Mohit", "onSaveInstanceState Method -------Fragment One-------")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("Mohit", "onDestroyView Method -------Fragment One-------")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Mohit", "onDestroy Method -------Fragment One-------")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("Mohit", "onDetach Method -------Fragment One-------")
    }
}