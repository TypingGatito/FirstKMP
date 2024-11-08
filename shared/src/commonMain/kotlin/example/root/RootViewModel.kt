package example.root

import example.base.BaseViewModel
import example.root.model.AppTab
import example.root.model.RootContract
import example.storage.SettingsManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RootViewModel(
    private val settingsManager: SettingsManager
) : BaseViewModel<RootContract.State, Nothing>() {

    init {
        settingsManager.themOsDarkFlow.onEach { isDark ->
            updateState { copy(themeIsDark = isDark) }
        }.launchIn(viewModelScope)
    }

    override fun initialState() = RootContract.State.NONE

    fun handleClickOnTab(appTab: AppTab) = updateState { copy(selectedTab = appTab) }
}