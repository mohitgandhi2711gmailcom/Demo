package com.example.demo.testing.fragment_backstack

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demo.R

class FragmentFive:Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Mohit", "onAttach Method -------Fragment Five-------")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Mohit", "onCreateView Method -------Fragment Five-------")
        return inflater.inflate(R.layout.fragment_five, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Mohit", "onCreate Method -------Fragment Five-------")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Mohit", "onViewCreated Method -------Fragment Five-------")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Mohit", "onStart Method -------Fragment Five-------")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Mohit", "onResume Method -------Fragment Five-------")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Mohit", "onPause Method -------Fragment Five-------")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("Mohit", "onViewStateRestored Method -------Fragment Five-------")
    }


    override fun onStop() {
        super.onStop()
        Log.e("Mohit", "onStop Method -------Fragment Five-------")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("Mohit", "onSaveInstanceState Method -------Fragment Five-------")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("Mohit", "onDestroyView Method -------Fragment Five-------")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Mohit", "onDestroy Method -------Fragment Five-------")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("Mohit", "onDetach Method -------Fragment Five-------")
    }
}