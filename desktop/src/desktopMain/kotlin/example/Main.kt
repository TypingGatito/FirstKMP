package example
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import example.di.getKoinInstance
import example.di.initKoin
import example.root.compose.RootScreen
import example.root.RootViewModel

fun main() {

    initKoin()

    application {
        val state = rememberWindowState().apply { size = DpSize(200.dp, 200.dp) }
        Window(onCloseRequest = {exitApplication()},
            state = state,
            title = "Example"
        ) {
            RootScreen()
        }
    }
}