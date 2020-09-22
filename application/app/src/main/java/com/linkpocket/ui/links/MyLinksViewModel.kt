package com.linkpocket.ui.links

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.GetListUseCase
import com.domain.model.Preview
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MyLinksViewModel(private val getListUseCase: GetListUseCase) : ViewModel() {

//    private val mainViewStateMutableLiveData = MutableLiveData<List<Preview>>()
//    val mainViewStateLiveData: LiveData<List<Preview>> = mainViewStateMutableLiveData
//
//    val uiState: ObservableField<com.presentation.PreviewState> = ObservableField()
//
//    init {
//        initList()
//    }
//
//    private fun initList() {
//        getListUseCase.getPreview()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<List<Preview>> {
//                override fun onComplete() {
//
//                }
//
//                override fun onSubscribe(d: Disposable) {
//                    uiState.set(com.presentation.PreviewState.Loading)
//                }
//
//                override fun onNext(previewList: List<Preview>) {
//                    uiState.set(com.presentation.PreviewState.Success)
//                    mainViewStateMutableLiveData.postValue(previewList)
//                }
//
//                override fun onError(e: Throwable) {
//                    uiState.set(com.presentation.PreviewState.Error)
//                }
//            })
//    }
}