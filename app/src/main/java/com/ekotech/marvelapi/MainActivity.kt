package com.ekotech.marvelapi

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ekotech.base.BaseActivity
import com.ekotech.characters.CharactersViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CharactersViewModel

    init {
        layoutRes = R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getComponentActivity()
            .inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CharactersViewModel::class.java)
        viewModel.characters.observe(this, Observer {
            println("view has something ${it.data.results[0].id}")
        })
    }
}
