package com.ekotech.marvelapi.main

import android.os.Bundle
import com.ekotech.marvelapi.R
import com.ekotech.marvelapi.base.BaseActivity
import com.ekotech.marvelapi.characters.CharactersFragment

class MainActivity : BaseActivity() {

    init {
        layoutRes = R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComponentActivity()
            .inject(this)
        initView()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, CharactersFragment.createCharactersFragment())
            .commit()
    }
}
