package com.ekotech.characters

import com.ekotech.characters.model.CharactersDTO
import io.reactivex.Single

interface CharactersRepoService {
    fun getCharacters(): Single<CharactersDTO>
}