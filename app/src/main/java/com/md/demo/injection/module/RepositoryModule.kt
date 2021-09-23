package com.md.demo.injection.module

import com.md.demo.data.ResponseRepository
import org.koin.dsl.module.applicationContext

val repositoryModule = applicationContext {
        factory { ResponseRepository(get(), get()) }
}