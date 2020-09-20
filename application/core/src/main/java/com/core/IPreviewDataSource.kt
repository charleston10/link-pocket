package com.core

import com.data.data_model.PreviewData
import io.reactivex.Observable

interface IPreviewDataSource {
    fun getList(): Observable<List<PreviewData>>
    fun addAll(list: List<PreviewData>)
}