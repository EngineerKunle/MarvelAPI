package com.ekotech.marvelapi.di

import com.ekotech.marvelapi.api.AppAPI
import com.ekotech.marvelapi.api.MarvelAPI
import com.ekotech.marvelapi.characters.CharactersRepoService
import com.ekotech.marvelapi.characters.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
internal abstract class NetworkModule {
    @Binds
    @Reusable
    internal abstract fun providesMarvelAPI(marvelAPI: MarvelAPI): AppAPI

    @Binds
    @Reusable
    internal abstract fun providesCharactersRepository(charactersRepository: CharactersRepository): CharactersRepoService
}