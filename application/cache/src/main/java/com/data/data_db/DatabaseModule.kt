package com.data.data_db

import com.core.datasource.IPreviewDataSource
import com.core.Named
import com.data.data_db.dao.IPreviewDao
import com.data.data_db.dao.PreviewDao
import com.data.data_db.datasource.PreviewDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DatabaseModule {

    val module = module {
        factory<IPreviewDao> { PreviewDao(androidContext()) }

        factory<IPreviewDataSource>(
            named(
                Named.DataSource.LOCAL_DATA_SOURCE_PREVIEW
            )
        ) { PreviewDataSource(get()) }
    }
}