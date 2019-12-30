package com.ekotech.api

import com.ekotech.marvelapi.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MarvelAPI @Inject constructor(): AppAPI {
    override fun createRetrofitClient(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.MARVEL_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}