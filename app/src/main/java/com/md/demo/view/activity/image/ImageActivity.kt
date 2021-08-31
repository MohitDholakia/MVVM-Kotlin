package com.md.demo.view.activity.image

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.md.demo.R
import com.md.demo.view.BaseActivity
import com.md.demo.view.fragment.list.ListFragment
import org.koin.android.architecture.ext.viewModel


class ImageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
