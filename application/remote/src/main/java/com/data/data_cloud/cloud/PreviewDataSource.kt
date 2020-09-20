package com.data.data_cloud.cloud

import com.core_bridge.IPreviewDataSource
import com.core_bridge.exception.ErrorException
import com.data.data_cloud.api.GitHubApi
import com.data.data_cloud.mapper.ResponseMapper
import com.data.data_model.PreviewData
import io.reactivex.Observable
import retrofit2.HttpException
import java.net.UnknownHostException

class PreviewDataSource(private val gitHubApi: GitHubApi) : IPreviewDataSource {

    private val mapper = ResponseMapper()

    override fun getList(): Observable<List<PreviewData>> {
        return gitHubApi.getList()
            .map { mapper.transform(it) }
            .onErrorResumeNext { error: Throwable ->
                if (error is HttpException && error.code() == 400) {
                    Observable.error(ErrorException.BadException)
                } else if (error is UnknownHostException) {
                    Observable.error(ErrorException.BadException)
                } else {
                    Observable.error(error)
                }
            }
    }

    override fun addAll(list: List<PreviewData>) {

    }
}