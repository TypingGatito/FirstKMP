package example.root.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import example.categories.list.compose.CategoriesScreen
import example.common.ui.theme.AppTheme
import example.common.ui.theme.AppThemeProvider
import example.di.getKoinInstance
import example.events.list.compose.EventsScreen
import example.root.RootViewModel
import example.root.model.AppTab
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
        AppTab.Events -> EventsScreen(getKoinInstance())
        AppTab.Settings -> SettingsScreen(getKoinInstance())
        AppTab.Categories -> CategoriesScreen(getKoinInstance())
    }
}