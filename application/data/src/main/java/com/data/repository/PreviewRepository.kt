package com.data.repository

import com.core.IPreviewDataStore
import com.data.mapper.ModelMapper
import com.domain.model.Preview
import com.domain.repository.IPreviewRepository
import io.reactivex.Observable

class PreviewRepository(
    private val dataStore: IPreviewDataStore
) : IPreviewRepository {

    private val mapper = ModelMapper()

    override fun getPreview(): Observable<List<Preview>> {
        return dataStore.getList()
            .map { mapper.transform(it) }
    }
}