package com.data.data_cloud

import com.core_bridge.IPreviewDataSource
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
            named("CloudDataSource")
        ) { PreviewDataSource(get()) }
    }
}