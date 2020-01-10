package com.ekotech.marvelapi.characters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ekotech.marvelapi.characters.model.CharactersDTO
import com.ekotech.marvelapi.characters.model.Data
import com.ekotech.marvelapi.characters.model.Result
import com.ekotech.marvelapi.characters.model.Thumbnail
import com.ekotech.marvelapi.helper.RxImmediateSchedulerRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.subjects.PublishSubject
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CharactersViewModelTest {
    @Rule
    @JvmField
    var testSchedule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val observer: Observer<CharactersDTO> = mockk(relaxed = true)
    private lateinit var charactersViewModel: CharactersViewModel
    private val charactersSubject = PublishSubject.create<CharactersDTO>()

    private val charactersRepository: CharactersRepoService = mockk(relaxed = true) {
        every { getCharacters() } returns charactersSubject.firstOrError()
    }

    @Before
    fun setUp() {
        charactersViewModel = CharactersViewModel(charactersRepository)
    }

    @Test
    internal fun `characters called successful`() {
        charactersSubject.onNext(charactersDTO)

        charactersViewModel.characters.observeForever(observer)

        verify {
            observer.onChanged(charactersDTO)
        }
    }

    companion object {
        private const val EXTENSION = "mock/../"
        private const val PATH = "path/mock"
        private val thumbnail = Thumbnail(extension = EXTENSION, path = PATH)
        private val result = Result(description = "Marvel", id = 1, thumbnail = thumbnail)
        private val data = Data(results = listOf(result))
        private val charactersDTO = CharactersDTO(data)
    }
}