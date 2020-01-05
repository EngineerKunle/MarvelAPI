package com.ekotech.ext

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.combinedObserveOnScheduleOn() = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())