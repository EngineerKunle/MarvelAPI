package com.ekotech.marvelapi.characters

import com.ekotech.marvelapi.api.AppAPI
import com.ekotech.marvelapi.api.CharactersService
import com.ekotech.marvelapi.api.NetworkOptions
import com.ekotech.marvelapi.characters.model.CharactersDTO
import io.reactivex.Single
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val marvelAPI: AppAPI,
    private val options: NetworkOptions
) : CharactersRepoService {

    override fun getCharacters(): Single<CharactersDTO> =
        marvelAPI.createRetrofitClient()
            .create(CharactersService::class.java)
            .getCharacters(apiKey = options.apiKey, hash = options.hash, offset = options.offSet, timestamp = options.timeStamp)
}