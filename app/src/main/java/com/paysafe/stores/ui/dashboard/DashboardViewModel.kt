package com.paysafe.stores.ui.dashboard

import com.peek.peek_sensor.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class DashboardState(
    val name: String? = null
)

@HiltViewModel
class DashboardViewModel @Inject constructor() : BaseViewModel<DashboardState>(DashboardState()) {
    private val dashboardStateFlow = MutableStateFlow(state)
    override val stateFlow: StateFlow<DashboardState>
        get() = dashboardStateFlow

}