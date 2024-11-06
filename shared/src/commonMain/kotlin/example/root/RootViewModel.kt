package example.root

import example.base.BaseViewModel
import example.storage.SettingsManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RootViewModel : BaseViewModel<RootContract.State, Nothing>() {

    init {
        SettingsManager.themOsDarkFlow.onEach { isDark ->
            updateState { copy(themeIsDark = isDark) }
        }.launchIn(viewModelScope)
    }

    override fun initialState() = RootContract.State.NONE
}