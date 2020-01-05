package com.ekotech.di

import android.app.Application
import com.ekotech.api.NetworkOptions
import com.ekotech.marvelapi.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(app: Application)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application,@BindsInstance networkOptions: NetworkOptions): AppComponent
    }

    fun inject(activity: MainActivity)
}