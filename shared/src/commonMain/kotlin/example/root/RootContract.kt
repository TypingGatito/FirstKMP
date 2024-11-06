package example.root

import example.base.BaseViewState
import example.common.ui.AppPrefs

class RootContract {

    data class State(
        val themeIsDark: Boolean,
        val firstDayIsMonday: Boolean
    ) : BaseViewState {

        val appPrefs: AppPrefs
            get() = AppPrefs(firstDayIsMonday = firstDayIsMonday)

        companion object {
            val NONE = State(
                themeIsDark = true,
                firstDayIsMonday = true
            )
        }
    }
}