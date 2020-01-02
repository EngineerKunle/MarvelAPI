package com.ekotech.characters

import com.ekotech.api.AppAPI
import com.ekotech.api.CharactersService
import com.ekotech.characters.model.CharactersDTO
import io.reactivex.Single
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val marvelAPI: AppAPI
) : CharactersRepoService {
    override fun getCharacters(): Single<CharactersDTO> =
        marvelAPI.createRetrofitClient()
            .create(CharactersService::class.java)
            .getCharacters(mapOf())
}