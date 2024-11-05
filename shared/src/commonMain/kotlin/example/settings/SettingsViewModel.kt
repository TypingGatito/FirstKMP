package example.settings

import example.base.BaseViewModel
import example.settings.SettingsContract.*
import example.platform.DeviceInfo

class SettingsViewModel: BaseViewModel<State, Nothing>() {
    init {
        val deviceInfo = DeviceInfo()
        updateState {
            copy(deviceInfo = deviceInfo.getSummary())
        }
    }
    override fun initialState(): State = State.NONE
}