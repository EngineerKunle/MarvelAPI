package com.ekotech.marvelapi.api

import retrofit2.Retrofit

interface AppAPI {
    fun createRetrofitClient(): Retrofit
}