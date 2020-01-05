package com.ekotech.characters

import com.ekotech.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val repository: CharactersRepository) : BaseViewModel() {
    fun provideSomething() {
        repository.getCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                println("we got somthing here ${it.data.results.size}")
            }, {
                println("errrorrrr")
            }).addToViewModelCompositeDisposable()
    }
}