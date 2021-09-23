package com.md.demo.injection.module

import com.md.demo.view.activity.main.MainViewModel
import com.md.demo.view.fragment.list.ListViewModel
import com.md.demo.view.fragment.listdetail.ListDetailViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val viewModelModule = applicationContext {
        viewModel { MainViewModel(get()) }
        viewModel { ListViewModel(get()) }
        viewModel { ListDetailViewModel(get()) }
}