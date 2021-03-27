package com.md.demo.view.activity.main

import android.os.Bundle
import com.md.demo.R
import com.md.demo.view.BaseActivity
import com.md.demo.view.fragment.list.ListFragment
import org.koin.android.architecture.ext.viewModel


class MainActivity : BaseActivity() {

    val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getList()

        viewModel.start()

        showMovieFragment()
    }


    private fun showMovieFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment())
                .commit()
    }


}
