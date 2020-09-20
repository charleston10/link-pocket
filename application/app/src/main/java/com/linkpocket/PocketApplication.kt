package com.linkpocket

import android.app.Application
import com.data.di.DataStoreModule
import com.data.data_db.DatabaseModule
import com.data.data_cloud.NetworkModule
import com.data.di.RepositoryModule
import com.domain.di.DomainModule
import com.linkpocket.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PocketApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PocketApplication)
            modules(
                PresentationModule.module,
                DomainModule.module,
                RepositoryModule.module,
                DatabaseModule.module,
                NetworkModule.module,
                DataStoreModule.module
            )
        }
    }
}