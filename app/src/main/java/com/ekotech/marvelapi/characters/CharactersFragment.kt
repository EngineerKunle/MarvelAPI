package com.ekotech.marvelapi.characters

import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ekotech.marvelapi.R
import com.ekotech.marvelapi.base.BaseFragment
import javax.inject.Inject

class CharactersFragment: BaseFragment() {

    init {
        layoutFragmentRes = R.layout.fragment_characters
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CharactersViewModel

    override fun setUpFragmentView(view: View) {
        getComponentFragment().inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CharactersViewModel::class.java)
        viewModel.characters.observe(this, Observer {
            val textView: TextView = view.findViewById(R.id.fragmentTextView)
            textView.text = "${it.data.results[1].id}"
        })
    }

    companion object {
        fun createCharactersFragment() = CharactersFragment()
    }
}
