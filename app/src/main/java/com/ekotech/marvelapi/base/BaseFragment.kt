package com.ekotech.marvelapi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ekotech.MarvelAPIApplication

abstract class BaseFragment: Fragment() {
    protected var layoutFragmentRes: Int = 0
    protected fun getComponentFragment() = MarvelAPIApplication.instance.getComponent()

    abstract fun setUpFragmentView(view: View)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutFragmentRes, container, false)
        setUpFragmentView(view)
        return view
    }
}