package example.settings

import example.base.BaseViewModel
import example.settings.SettingsContract.*
import example.platform.DeviceInfo
import example.storage.SettingsManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SettingsViewModel: BaseViewModel<State, Nothing>() {
    init {
        SettingsManager.themOsDarkFlow.onEach {
            updateState { copy(themeIsDark = it) }
        }.launchIn(viewModelScope)

        val deviceInfo = DeviceInfo()
        updateState {
            copy(deviceInfo = deviceInfo.getSummary())
        }
    }
    override fun initialState(): State = State.NONE

    fun switchTheme(isDark: Boolean) {
        SettingsManager.themeIsDark = isDark
    }
}