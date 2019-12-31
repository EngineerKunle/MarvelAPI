package com.ekotech.api

import com.ekotech.characters.model.CharactersDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CharactersService {

    @GET("/characters")
    fun getCharacters(@QueryMap queryMap: Map<String, Any>): Single<CharactersDTO>
}