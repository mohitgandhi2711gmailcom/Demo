package com.example.demo.testing.fragment_backstack

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demo.R

class FragmentTwo:Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Mohit", "onAttach Method -------Fragment Two-------")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("Mohit", "onViewStateRestored Method -------Fragment Two-------")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Mohit", "onCreateView Method -------Fragment Two-------")
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Mohit", "onCreate Method -------Fragment Two-------")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Mohit", "onViewCreated Method -------Fragment Two-------")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Mohit", "onStart Method -------Fragment Two-------")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Mohit", "onResume Method -------Fragment Two-------")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Mohit", "onPause Method -------Fragment Two-------")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Mohit", "onStop Method -------Fragment Two-------")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("Mohit", "onSaveInstanceState Method -------Fragment Two-------")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("Mohit", "onDestroyView Method -------Fragment Two-------")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Mohit", "onDestroy Method -------Fragment Two-------")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("Mohit", "onDetach Method -------Fragment Two-------")
    }
}