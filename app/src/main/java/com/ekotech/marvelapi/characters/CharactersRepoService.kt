package com.ekotech.marvelapi.characters

import com.ekotech.marvelapi.characters.model.CharactersDTO
import io.reactivex.Single

interface CharactersRepoService {
    fun getCharacters(): Single<CharactersDTO>
}