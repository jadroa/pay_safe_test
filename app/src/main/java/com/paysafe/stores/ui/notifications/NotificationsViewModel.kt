package com.paysafe.stores.ui.notifications

import com.peek.peek_sensor.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class NotificationState(
    val name: String? = null
)

@HiltViewModel
class NotificationsViewModel @Inject constructor(): BaseViewModel<NotificationState>(NotificationState()) {
    private val notificationStateFlow = MutableStateFlow(state)
    override val stateFlow: StateFlow<NotificationState>
        get() = notificationStateFlow
}