package com.example.travelapp.fragment

import androidx.fragment.app.Fragment
import com.example.travelapp.view.viewpods.EmptyViewPod
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment() {
    abstract class BaseFragment : Fragment() {
        protected lateinit var viewPortEmpty: EmptyViewPod
        protected fun showSnackbar(message: String) {
            activity?.window?.decorView?.let {
                Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}