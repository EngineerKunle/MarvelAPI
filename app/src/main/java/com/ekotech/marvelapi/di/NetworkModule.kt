package com.ekotech.marvelapi.di

import com.ekotech.marvelapi.api.AppAPI
import com.ekotech.marvelapi.api.MarvelAPI
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class NetworkModule {
    @Binds
    @Reusable
    abstract fun providesMarvelAPI(marvelAPI: MarvelAPI): AppAPI
}