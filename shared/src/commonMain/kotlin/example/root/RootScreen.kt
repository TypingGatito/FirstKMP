package example.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import example.common.ui.AppTheme
import example.common.ui.AppThemeProvider
import example.settings.compose.SettingsScreen
import example.settings.SettingsViewModel

@Composable
fun RootScreen(viewModel: RootViewModel) {

    val state by viewModel.state.collectAsState()

    AppTheme(
        themeIsDark = state.themeIsDark,
        appPrefs = state.appPrefs
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .background(AppThemeProvider.colors.background)
        ) {
            SettingsScreen(SettingsViewModel())
        }
    }

}