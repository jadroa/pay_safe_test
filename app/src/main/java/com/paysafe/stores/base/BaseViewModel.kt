package com.peek.peek_sensor.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<State>(protected val state: State) : ViewModel() {
    abstract val stateFlow: StateFlow<State>
}