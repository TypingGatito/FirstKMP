package example.root.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import example.categories.CategoriesScreen
import example.common.ui.AppTheme
import example.common.ui.AppThemeProvider
import example.di.getKoinInstance
import example.events.EventScreen
import example.root.RootViewModel
import example.root.model.AppTab
import example.settings.SettingsViewModel
import example.settings.compose.SettingsScreen

@Composable
fun RootScreen() {

    val viewModel = getKoinInstance<RootViewModel>()
    val state by viewModel.state.collectAsState()

    AppTheme(
        themeIsDark = state.themeIsDark,
        appPrefs = state.appPrefs
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(AppThemeProvider.colors.background)
        ) {
            RootNavigation(state.selectedTab)
            RootBottomBar(state.selectedTab, fun(appTab: AppTab) {
                viewModel.handleClickOnTab(appTab)
            })
        }
    }

}

@Composable
fun BoxScope.RootNavigation(selectedTab: AppTab) {
    when(selectedTab) {
        AppTab.Events -> EventScreen()
        AppTab.Settings -> SettingsScreen(getKoinInstance())
        AppTab.Categories -> CategoriesScreen()
    }
}