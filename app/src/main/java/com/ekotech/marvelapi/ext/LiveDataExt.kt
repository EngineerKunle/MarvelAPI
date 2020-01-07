package com.ekotech.marvelapi.ext

import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.BackpressureStrategy
import io.reactivex.subjects.BehaviorSubject

fun <T> BehaviorSubject<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this.toFlowable(BackpressureStrategy.MISSING))