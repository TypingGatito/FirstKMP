package example.storage

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.russhwolf.settings.Settings


class SettingsManager(private val settings: Settings) {

    private val THEME_KEY = "THEME_KEY"

    var themeIsDark: Boolean
        set(value) {
            this._themeDarkFlow.update { value }
            settings.putBoolean(THEME_KEY, value)
        }
        get() = settings.getBoolean(THEME_KEY, true)

    private val _themeDarkFlow = MutableStateFlow(themeIsDark)

    val themOsDarkFlow = _themeDarkFlow.asStateFlow()
}