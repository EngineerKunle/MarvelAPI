package com.ekotech

import android.app.Application
import com.ekotech.di.AppComponent
import com.ekotech.di.DaggerAppComponent

class MarvelAPIApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.create()
        super.onCreate()
    }
}