package example.settings

import example.base.BaseViewModel
import example.settings.SettingsContract.*
import example.platform.DeviceInfo
import example.storage.SettingsManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SettingsViewModel (
    private val deviceInfo: DeviceInfo,
    private val settingsManager: SettingsManager
): BaseViewModel<State, Nothing>() {
    init {
        settingsManager.themOsDarkFlow.onEach {
            updateState { copy(themeIsDark = it) }
        }.launchIn(viewModelScope)
        updateState {
            copy(info = deviceInfo.getSummary())
        }
    }
    override fun initialState(): State = State.NONE

    fun switchTheme(isDark: Boolean) {
        settingsManager.themeIsDark = isDark
    }
}