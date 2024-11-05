
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import example.sayHello
import example.root.RootScreen
import example.settings.SettingsScreen
import example.settings.SettingsViewModel

fun main() {
    sayHello()

    application {
        val state = rememberWindowState().apply { size = DpSize(200.dp, 200.dp) }
        Window(onCloseRequest = {exitApplication()},
            state = state,
            title = "Example"
        ) {
            //SayHelloFromCommon()
            //RootScreen()
            SettingsScreen(SettingsViewModel())
        }
    }
}