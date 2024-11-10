package example.common.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

data class AppColors (
    var accent: Color,
    var background: Color,
    var surface: Color,
    var onBackground: Color,
    var onSurface: Color,
)

val lightPalette = AppColors(
    accent = Color(0xFFFFF590),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFFAFAFA),
    onBackground = Color(0xFF000000),
    onSurface = Color(0xFF333333),
)

val darkPalette = AppColors(
    accent = Color(0xFFFFD54F),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFDDDDDD),
)

object AppThemeProvider {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val appPrefs: AppPrefs
        @Composable
        @ReadOnlyComposable
        get() = LocalAppPrefs.current
}