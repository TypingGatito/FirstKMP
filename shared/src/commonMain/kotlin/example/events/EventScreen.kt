package example.events

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import example.common.ui.calendar.compose.CalendarColors
import example.common.ui.calendar.compose.DatePickerView
import example.common.ui.theme.AppThemeProvider
import example.di.getKoinInstance

@Composable
fun BoxScope.EventScreen() {
    DatePickerView(
        viewModel = getKoinInstance(),
        colors = CalendarColors.default.copy(
            colorSurface = AppThemeProvider.colors.surface,
            colorOnSurface = AppThemeProvider.colors.onSurface,
            colorAccent = AppThemeProvider.colors.accent
        ),
        firstDayIsMonday = AppThemeProvider.appPrefs.firstDayIsMonday,
        labels = emptyList(),
        selectDayListener = { day -> }
    )
}