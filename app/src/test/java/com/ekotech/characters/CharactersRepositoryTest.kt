package com.ekotech.characters

import com.ekotech.api.AppAPI
import com.ekotech.api.CharactersService
import com.ekotech.api.NetworkOptions
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Test

class CharactersRepositoryTest {
    private val appAPI: AppAPI = mockk(relaxed = true)
    private val options: NetworkOptions = mockk(relaxed = true)
    private val charactersRepository = CharactersRepository(appAPI, options)

    @Test
    fun `get characters success`() {
        val result = charactersRepository.getCharacters().test()

//        every { appAPI.createRetrofitClient()
//            .create(CharactersService::class.java)
//            .getCharacters(any(), any(), any(), any()) } returns Single.just()
    }
}