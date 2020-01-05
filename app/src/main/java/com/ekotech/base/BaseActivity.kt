package com.ekotech.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ekotech.MarvelAPIApplication

abstract class BaseActivity: AppCompatActivity() {

    protected fun getComponentActivity() = MarvelAPIApplication.instance.getComponent()
    protected var layoutRes: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }
}