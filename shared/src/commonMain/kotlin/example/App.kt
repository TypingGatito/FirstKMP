package example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


fun sayHello() {
    println("Hello")
}

@Composable
fun SayHelloFromCommon() {
    Box(modifier = Modifier.size(200.dp),
        contentAlignment = Alignment.Center) {
        Text("Common hello", modifier = Modifier.align(alignment = Alignment.Center))
    }
}
