package example.settings.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import example.common.ui.theme.AppThemeProvider
import example.common.ui.theme.LocalAppColors
import example.settings.SettingsViewModel
import example.MR

@Composable
fun BoxScope.SettingsScreen(
    viewModel: SettingsViewModel
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center)
    ) {
        Text("Settings")

        Card(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            backgroundColor = LocalAppColors.current.background
        ) {
            Text(
                state.info, color = AppThemeProvider.colors.onSurface,
                modifier = Modifier.padding(16.dp)
            )
        }

        Row(
            modifier = Modifier.padding(16.dp)
                .background(AppThemeProvider.colors.surface, RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(MR.strings.dark_theme), modifier = Modifier.weight(1f),
                color = AppThemeProvider.colors.onSurface
            )
            Checkbox(
                state.themeIsDark, onCheckedChange = { viewModel.switchTheme(it) },
                colors = CheckboxDefaults.colors(
                    checkedColor = AppThemeProvider.colors.accent,
                    uncheckedColor = AppThemeProvider.colors.onSurface
                )
            )
        }

    }
}