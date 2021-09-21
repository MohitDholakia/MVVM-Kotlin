package com.md.demo

import android.app.Application
import com.md.demo.injection.module.localDataSourceModule
import com.md.demo.injection.module.remoteDatasourceModule
import com.md.demo.injection.module.repositoryModule
import com.md.demo.injection.module.viewModelModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /*if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }*/

        /*startKoin(this, listOf(
                remoteDatasourceModule,
                localDataSourceModule,
                repositoryModule,
                viewModelModule))*/
    }
}
