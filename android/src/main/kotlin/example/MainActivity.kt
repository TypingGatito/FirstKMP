package example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import example.root.RootScreen
import example.root.RootViewModel

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootScreen(RootViewModel())
        }
    }
}