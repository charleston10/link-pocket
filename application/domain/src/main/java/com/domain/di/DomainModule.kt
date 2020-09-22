package com.domain.di

import com.core.usecase.IGetListUseCase
import com.domain.GetListUseCase
import com.domain.model.Preview
import org.koin.dsl.module

object DomainModule {
    val module = module {
        factory<IGetListUseCase<Preview>> { GetListUseCase(get()) }
    }
}