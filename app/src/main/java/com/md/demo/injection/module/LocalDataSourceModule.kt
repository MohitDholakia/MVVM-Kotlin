package com.md.demo.injection.module

import com.md.demo.data.local.MyDatabase
import org.koin.dsl.module.applicationContext

val localDataSourceModule = applicationContext {
    factory { MyDatabase.getInstance(get()) }
}