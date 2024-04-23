import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
@Composable
@Preview
fun act3(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .absolutePadding(left = 150.dp, right = 150.dp)
    ){

        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(40.dp,150.dp)

        ){
            Text("Box 1")
        }

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .size(40.dp,320.dp)
        ){
            Text("Box 2")
        }
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .size(40.dp,320.dp)
        ){
            Text("Box 3")
        }
        Box (
            modifier = Modifier
                .background(Color.Green)
                .size(40.dp,150.dp)
        ){
            Text("Box 4")

        }
    }
}
@Composable
@Preview
fun act4(){//No se porque no funciona

    Row (
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = (Alignment.Bottom)

    ){
        Surface (
            modifier = Modifier
                .border(5.dp, Color.Red)
                .size(height = 600.dp, width = 70.dp)
                .padding(10.dp,0.dp)

        ){
            Text("Ejecicio 1")
        }

        Surface (
            modifier = Modifier
                .border(5.dp, Color.Blue)
                .padding(10.dp,0.dp)
                .size(height = 400.dp, width = 70.dp)
        ){
            Text("Ejecicio 2")
        }

        Surface (
            modifier = Modifier
                .border(5.dp, Color.Red)
                .padding(10.dp,0.dp)
                .size(height = 200.dp, width = 70.dp)
        ){
            Text("Ejecicio 3")
        }

        Surface (
            modifier = Modifier
                .border(5.dp, Color.Blue)
                .padding(10.dp,0.dp)
                .size(height = 100.dp, width = 70.dp)
        ){
            Text("Ejecicio 1")
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

        act3()

    }
}
