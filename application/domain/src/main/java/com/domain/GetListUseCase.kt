package com.domain

import com.core.usecase.IGetListUseCase
import com.domain.model.Preview
import com.domain.repository.IPreviewRepository
import io.reactivex.Observable

class GetListUseCase(
    private val previewRepository: IPreviewRepository
): IGetListUseCase<Preview> {

    override fun execute(): Observable<List<Preview>> {
        return previewRepository.getPreview()
    }
}