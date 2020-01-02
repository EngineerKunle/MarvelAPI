package com.ekotech.di

import com.ekotech.api.AppAPI
import com.ekotech.api.MarvelAPI
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class NetworkModule {
    @Provides
    @Reusable
    fun providesMarvelAPI(marvelAPI: MarvelAPI): AppAPI = marvelAPI
}