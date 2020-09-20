package com.data.data_cloud

import com.core.IPreviewDataSource
import com.core.Named
import com.data.data_cloud.api.GitHubApi
import com.data.data_cloud.cloud.PreviewDataSource
import com.data.data_cloud.network.HTTPClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

object NetworkModule {

    val module = module {
        single { HTTPClient() }
        factory { get<HTTPClient>().create(GitHubApi::class) }

        factory<IPreviewDataSource>(
            named(
                Named.DataSource.CLOUD_DATA_SOURCE_PREVIEW
            )
        ) { PreviewDataSource(get()) }
    }
}