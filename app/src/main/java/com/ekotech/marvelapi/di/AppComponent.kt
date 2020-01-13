package com.ekotech.marvelapi.di

import android.app.Application
import android.content.Context
import com.ekotech.marvelapi.api.NetworkOptions
import com.ekotech.marvelapi.characters.CharactersFragment
import com.ekotech.marvelapi.imageloader.PicassoModule
import com.ekotech.marvelapi.main.MainActivity
import com.ekotech.marvelapi.splash.SplashActivity
import com.ekotech.marvelapi.splash.SplashModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,
    ViewModelModule::class,
    SplashModule::class,
    PicassoModule::class])
interface AppComponent {
    fun inject(app: Application)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application,@BindsInstance networkOptions: NetworkOptions): AppComponent
    }

    fun inject(activity: SplashActivity)
    fun inject(activity: MainActivity)

    fun inject(fragment: CharactersFragment)
}