package com.data.di

import com.core_bridge.IPreviewDataStore
import com.core_bridge.Named
import com.data.datasource.PreviewDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataStoreModule {
    val module = module {
        factory<IPreviewDataStore> {
            PreviewDataStore(
                get(
                    named(Named.DataSource.CLOUD_DATA_SOURCE_PREVIEW)
                ),
                get(
                    named(Named.DataSource.LOCAL_DATA_SOURCE_PREVIEW)
                )
            )
        }
    }
}