package com.ekotech.marvelapi.splash

import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
internal abstract class SplashModule {
    @Binds
    @Reusable
    internal abstract fun providesTimerSplash(timerSplash: TimerSplash): ITimerSplash
}