package com.core.usecase

import io.reactivex.Observable

interface IGetListUseCase<T> {
    fun execute() : Observable<List<T>>
}