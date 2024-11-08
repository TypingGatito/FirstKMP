package example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import example.di.getKoinInstance
import example.root.compose.RootScreen
import example.root.RootViewModel

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootScreen()
        }
    }
}