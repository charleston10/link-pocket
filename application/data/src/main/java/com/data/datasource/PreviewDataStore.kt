package com.data.datasource

import com.core_bridge.IPreviewDataSource
import com.core_bridge.IPreviewDataStore
import com.core_bridge.exception.ErrorException
import com.data.data_model.PreviewData
import io.reactivex.Observable

class PreviewDataStore(
    private val cloudDataSource: IPreviewDataSource,
    private val localDataSource: IPreviewDataSource,
) : IPreviewDataStore {

    override fun getList(): Observable<List<PreviewData>> {
        return cloudDataSource.getList()
            .doOnNext {
                localDataSource.addAll(it)
            }
            .onErrorResumeNext { error: Throwable ->
                if (error is ErrorException.BadException) {
                    localDataSource.getList()
                } else {
                    Observable.error(error)
                }
            }
    }
}