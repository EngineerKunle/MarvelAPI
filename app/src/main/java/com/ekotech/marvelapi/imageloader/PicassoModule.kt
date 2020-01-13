package com.ekotech.marvelapi.imageloader

import dagger.Module
import dagger.Provides
import dagger.Reusable

@Suppress("unused")
@Module
object PicassoModule {
    @Provides
    @Reusable
    internal fun providePicasso(): PicassoLoader = PicassoLoader()
}