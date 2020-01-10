package com.ekotech.marvelapi.splash

import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class SplashModule {
    @Binds
    @Reusable
    abstract fun providesTimerSplash(timerSplash: TimerSplash): ITimerSplash
}