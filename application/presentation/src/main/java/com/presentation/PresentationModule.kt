package com.presentation

import io.reactivex.Scheduler
import org.koin.dsl.module

object PresentationModule {

    val module = module {
        factory<IPreviewViewModel> { (postThreadExecutor: Scheduler) ->
            PreviewViewModel(get(), postThreadExecutor)
        }
    }
}