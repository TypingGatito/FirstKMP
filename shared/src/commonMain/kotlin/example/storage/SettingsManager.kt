package example.storage

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object SettingsManager {

    var themeIsDark: Boolean = false
        set(value) {
            this._themeDarkFlow.update { value }
            field = value
        }

    private val _themeDarkFlow = MutableStateFlow(themeIsDark)

    val themOsDarkFlow = _themeDarkFlow.asStateFlow()
}