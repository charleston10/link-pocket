package com.data.data_db.datasource

import com.core_bridge.IPreviewDataSource
import com.data.data_db.dao.IPreviewDao
import com.data.data_db.mapper.EntityMapper
import com.data.data_model.PreviewData
import io.reactivex.Observable

class PreviewDataSource(private val dao: IPreviewDao) : IPreviewDataSource {

    private val mapper = EntityMapper()

    override fun getList(): Observable<List<PreviewData>> {
        return dao.getAll()
            .map { mapper.transform(it) }
    }

    override fun addAll(list: List<PreviewData>) {

    }
}