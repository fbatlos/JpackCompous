import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun act1() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center


    ) {
        Box(
            modifier = Modifier.background(Color.Blue).size(20.dp)
        ) {

        }
    }
}
@Composable
@Preview
fun act2() {
    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.Magenta),
        contentAlignment = Alignment.Center


    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .size(300.dp,200.dp),
            contentAlignment = Alignment
                .BottomCenter

        ) {
            Text(
                text = "Hola soy un ejemplo por y para dirgo",
                modifier = Modifier
                    .padding(2.dp),
                color = Color
                    .Yellow

            )
        }
    }
}
fun main() = application {
    val windowState = rememberWindowState(size = DpSize(1200.dp,800.dp))
    Window(
        onCloseRequest = ::exitApplication,
        title = "Diego me mata.",
        state = windowState
    ){

        act2()

    }
}
