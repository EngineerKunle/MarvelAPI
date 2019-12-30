package com.ekotech.api

import retrofit2.Retrofit

interface AppAPI {
    fun createRetrofitClient(): Retrofit
}