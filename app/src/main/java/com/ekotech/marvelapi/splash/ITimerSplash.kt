package com.ekotech.marvelapi.splash

import io.reactivex.Completable

interface ITimerSplash {
    fun timerForSplashScreen(): Completable
}