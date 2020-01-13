package com.ekotech.marvelapi.characters

import com.ekotech.marvelapi.api.AppAPI
import com.ekotech.marvelapi.api.CharactersService
import com.ekotech.marvelapi.api.NetworkOptions
import com.ekotech.marvelapi.characters.model.CharactersDTO
import com.ekotech.marvelapi.characters.model.Data
import com.ekotech.marvelapi.characters.model.Result
import com.ekotech.marvelapi.characters.model.Thumbnail
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

class CharactersRepositoryTest {
    private val appAPI: AppAPI = mockk(relaxed = true)
    private val options: NetworkOptions = mockk(relaxed = true)
    private val charactersRepository = CharactersRepository(appAPI, options)

    @Test
    fun `GET characters success`() {
        //given
        every {
            appAPI.createRetrofitClient()
                .create(CharactersService::class.java)
                .getCharacters(any(), any(), any(), any())
        } returns Single.just(charactersDTO)

        //when
        val result = charactersRepository.getCharacters().test()

        verify {
            appAPI.createRetrofitClient()
                .create(CharactersService::class.java)
                .getCharacters(any(), any(), any(), any())
        }

        //then
        result.assertValue(charactersDTO)
        result.assertValue {
            it.data.results[0].thumbnail.extension == EXTENSION
            it.data.results[0].thumbnail.path == PATH
        }
    }

    @Test
    fun `GET characters failed`() {
        //given
        every {
            appAPI.createRetrofitClient()
                .create(CharactersService::class.java)
                .getCharacters(any(), any(), any(), any())
        } returns Single.error(Exception("Failed connection :/"))

        //when
        val result = charactersRepository.getCharacters().test()

        verify {
            appAPI.createRetrofitClient()
                .create(CharactersService::class.java)
                .getCharacters(any(), any(), any(), any())
        }

        //then
        result.assertFailure(Exception::class.java)
    }

    companion object {
        private const val EXTENSION = "mock/../"
        private const val PATH = "path/mock"
        private val thumbnail = Thumbnail(extension = EXTENSION, path = PATH)
        private val result = Result(description = "Marvel", id = 1, thumbnail = thumbnail, name = "characters")
        private val data = Data(results = listOf(result))
        private val charactersDTO = CharactersDTO(data)
    }
}