package com.md.demo.injection.module

import com.md.demo.view.activity.main.MainViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val viewModelModule = applicationContext {
    viewModel { MainViewModel(get()) }
}