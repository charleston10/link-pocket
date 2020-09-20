package com.core

import com.data.data_model.PreviewData
import io.reactivex.Observable

interface IPreviewDataStore {
    fun getList(): Observable<List<PreviewData>>
}