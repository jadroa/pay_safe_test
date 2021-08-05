package com.paysafe.stores.model

sealed class LoadingState {
    object Loading : LoadingState()
    object Data : LoadingState()
    data class Error(val errorMessage: String? = null) : LoadingState()
}
