package example.root.model

import com.sun.jdi.connect.Connector.SelectedArgument
import example.base.BaseViewState
import example.common.ui.AppPrefs

class RootContract {

    data class State(
        val themeIsDark: Boolean,
        val firstDayIsMonday: Boolean,
        val selectedTab: AppTab
    ) : BaseViewState {

        val appPrefs: AppPrefs
            get() = AppPrefs(firstDayIsMonday = firstDayIsMonday)

        companion object {
            val NONE = State(
                themeIsDark = true,
                firstDayIsMonday = true,
                selectedTab = AppTab.Events
            )
        }
    }
}