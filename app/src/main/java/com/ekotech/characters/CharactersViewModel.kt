package com.ekotech.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ekotech.base.BaseViewModel
import com.ekotech.characters.model.CharactersDTO
import com.ekotech.ext.combinedObserveOnScheduleOn
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val repository: CharactersRepository) : BaseViewModel() {

    private val _characters: MutableLiveData<CharactersDTO> by lazy {
        MutableLiveData<CharactersDTO>().also {
            loadCharacters()
        }
    }

    var characters: LiveData<CharactersDTO> = _characters

    private fun loadCharacters() {
        repository.getCharacters()
            .combinedObserveOnScheduleOn().subscribe({
                _characters.postValue(it)
            }, {
                println("errror view model")
            }).addToViewModelCompositeDisposable()
    }

    private sealed class ViewStateUpdate {
        object ShowLoading : ViewStateUpdate()
        data class LoadedView(val characters: CharactersDTO): ViewStateUpdate()
    }
}