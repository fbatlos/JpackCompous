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
fun MainScreen() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        //Aquí un componente
        Text(
            text = "Hola mundo cruel",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.wrapContentSize(Alignment.TopEnd),

        )
    }
}

@Composable
fun MainScreen2() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Surface(
                color = Color.Green,
                modifier = Modifier.size(60.dp)
            ) {}
            Surface(
                color = Color.Black,
                modifier = Modifier.size(60.dp)
            ) {}
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

            MainScreen2()

    }
}
