package com.presentation

sealed class PreviewState {
    class Success(val list: List<PreviewModel>) : PreviewState()
    object Loading : PreviewState()
    object Error : PreviewState()
}