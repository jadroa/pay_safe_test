package com.paysafe.stores.ui.stores

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paysafe.stores.location.LocationManager
import com.paysafe.stores.model.LoadingState
import com.paysafe.stores.model.Store
import com.paysafe.stores.network.PSRepo
import com.peek.peek_sensor.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

data class StoresState(
    val loadingState: LoadingState = LoadingState.Loading,
    val stores: List<Store>? = null,
    val location: Location? = null
)

@HiltViewModel
class StoresViewModel @Inject constructor(
    private val repository: PSRepo,
    private val locationManager: LocationManager
) : BaseViewModel<StoresState>(StoresState()) {
    private val storesStateFlow = MutableStateFlow(state)
    override val stateFlow: StateFlow<StoresState>
        get() = storesStateFlow

    fun startLocationUpdates() {
        viewModelScope.launch {
            locationManager.startLocationUpdates().collect {
                storesStateFlow.value = state.copy(location = it)
            }
        }
    }

    fun findStores() {
        viewModelScope.launch {
            storesStateFlow.value.location?.let {
                repository.getStores(it.longitude, it.latitude, 1000, 10, "testApplication")
                    .collect { stores ->
                        storesStateFlow.value = state.copy(stores = stores)
                    }
            }
        }
    }
}