package com.md.demo

import android.app.Application
import com.md.demo.injection.module.*
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
        override fun onCreate() {
                super.onCreate()
                startKoin(
                        this, listOf(
                                remoteDatasourceModule,
                                localDataSourceModule,
                                repositoryModule,
                                viewModelModule
                        )
                )
        }
}