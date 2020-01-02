package com.ekotech

import android.app.Application
import com.ekotech.api.NetworkOptions
import com.ekotech.di.AppComponent
import com.ekotech.di.DaggerAppComponent
import com.ekotech.marvelapi.BuildConfig

class MarvelAPIApplication : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.factory().create(this, createNetworkOptions())
        appComponent.inject(this)
        super.onCreate()
    }

    private fun createNetworkOptions(): NetworkOptions =
        NetworkOptions(
            apiKey = BuildConfig.MARVEL_API,
            hash = "",
            timeStamp = 1,
            offSet = 500)
}