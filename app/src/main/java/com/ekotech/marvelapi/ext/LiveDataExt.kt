package com.ekotech.marvelapi.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.Flowable
import io.reactivex.Single

fun <T> Single<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable())

fun <T> LiveData<T>.toFlowable(owner: LifecycleOwner): Flowable<T> = Flowable.fromPublisher(LiveDataReactiveStreams.toPublisher(owner, this))