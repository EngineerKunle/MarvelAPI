package com.ekotech

import android.app.Application
import com.ekotech.api.NetworkOptions
import com.ekotech.di.AppComponent
import com.ekotech.di.DaggerAppComponent
import com.ekotech.marvelapi.BuildConfig
import com.ekotech.utils.convertToMD5

class MarvelAPIApplication : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.factory().create(this, createNetworkOptions())
        appComponent.inject(this)
        super.onCreate()
        instance = this
    }

    @Synchronized fun getComponent(): AppComponent = appComponent

    private fun createNetworkOptions(): NetworkOptions =
        NetworkOptions(
            apiKey = BuildConfig.MARVEL_API_KEY,
            hash = createHash(),
            timeStamp = timeStamp(),
            offSet = 500)

    private fun createHash(): String {
        val apiKey = BuildConfig.MARVEL_API_KEY
        val privateKey = BuildConfig.MARVEL_PRIVATE_KEY
        val timeStamp = timeStamp()
        val hash = timeStamp.toString() + privateKey + apiKey

        return hash.convertToMD5()
    }

    private fun timeStamp(): Long = System.currentTimeMillis() / 1000

    companion object {
        lateinit var instance: MarvelAPIApplication
        private set
    }
}