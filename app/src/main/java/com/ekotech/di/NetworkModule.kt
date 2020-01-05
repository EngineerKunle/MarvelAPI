package com.ekotech.di

import com.ekotech.api.AppAPI
import com.ekotech.api.MarvelAPI
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
abstract class NetworkModule {
    @Binds
    @Reusable
    abstract fun providesMarvelAPI(marvelAPI: MarvelAPI): AppAPI
}