package com.md.demo

import android.app.Application
import com.md.demo.injection.module.localDataSourceModule
import com.md.demo.injection.module.remoteDatasourceModule
import com.md.demo.injection.module.repositoryModule
import com.md.demo.injection.module.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                remoteDatasourceModule,
                localDataSourceModule,
                repositoryModule,
                viewModelModule))
    }
}