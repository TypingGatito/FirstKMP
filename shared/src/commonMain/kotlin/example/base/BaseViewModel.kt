package example.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel<State: BaseViewState, Event: BaseEvent> {

    val viewModelScope = CoroutineScope(SupervisorJob())

    private val _state = MutableStateFlow(initialState())
    val state = _state.asStateFlow()

    private val _events = Channel<Event>()
    val events = _events.receiveAsFlow()

    fun updateState(block: State.() -> State) {
        _state.value = block(_state.value)
    }

    fun onDestroy() {
        viewModelScope.cancel()
    }

    open fun onCleared() {}

    abstract fun initialState(): State
}