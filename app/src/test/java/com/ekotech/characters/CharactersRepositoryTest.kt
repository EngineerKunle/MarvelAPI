package com.ekotech.characters

import com.ekotech.api.AppAPI
import com.ekotech.api.CharactersService
import com.ekotech.api.NetworkOptions
import com.ekotech.characters.model.CharactersDTO
import com.ekotech.characters.model.Data
import com.ekotech.characters.model.Result
import com.ekotech.characters.model.Thumbnail
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
    fun `get characters success`() {
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
            it.data.results[0].thumbnail.extension == "mock/../"
            it.data.results[0].thumbnail.path == "path/mock"
        }
    }

    @Test
    fun `get characters failed`() {
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
        private val thumbnail = Thumbnail(extension = "mock/../", path = "path/mock")
        private val result = Result(description = "Marvel", id = 1, thumbnail = thumbnail)
        private val data = Data(results = listOf(result))
        private val charactersDTO = CharactersDTO(data)
    }
}