package com.presentation

import com.domain.GetListUseCase
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

interface InputPreviewViewModel {
    fun disposable()
}

interface OutputPreviewViewModel {
    val stateObservable: Observable<PreviewState>
}

interface IPreviewViewModel {
    val input: InputPreviewViewModel
    val output: OutputPreviewViewModel
}

class PreviewViewModel(
    private val getListUseCase: GetListUseCase,
    private val postThreadExecutor: Scheduler
) : IPreviewViewModel,
    InputPreviewViewModel,
    OutputPreviewViewModel {

    private val disposables = CompositeDisposable()
    private val mapper = PreviewMapper()

    private val stateMutable = PublishSubject.create<PreviewState>()
    override val stateObservable: Observable<PreviewState> = stateMutable

    override val input: InputPreviewViewModel get() = this
    override val output: OutputPreviewViewModel get() = this

    init {
        initList()
    }

    override fun disposable() {
        disposables.dispose()
    }

    private fun initList() {
        getListUseCase.getPreview()
            .doOnSubscribe { disposables.addAll(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(postThreadExecutor)
            .map { mapper.transform(it) }
            .subscribe(object : Observer<List<PreviewModel>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    stateMutable.onNext(PreviewState.Loading)
                }

                override fun onNext(previewList: List<PreviewModel>) {
                    stateMutable.onNext(PreviewState.Success(previewList))
                }

                override fun onError(e: Throwable) {
                    stateMutable.onNext(PreviewState.Error)
                }
            })
    }
}