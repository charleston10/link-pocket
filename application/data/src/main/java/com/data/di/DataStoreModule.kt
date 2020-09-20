package com.data.di

import com.core_bridge.IPreviewDataStore
import com.data.datasource.PreviewDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataStoreModule {
    val module = module {
        factory<IPreviewDataStore> {
            PreviewDataStore(
                get(named("CloudDataSource")),
                get(named("LocalDataSource"))
            )
        }
    }
}