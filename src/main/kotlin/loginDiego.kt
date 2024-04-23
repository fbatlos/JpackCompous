import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val windowState = rememberWindowState(size = DpSize(1200.dp,800.dp))
    Window(
        onCloseRequest = ::exitApplication,
        title = "Diego me mata.",
        state = windowState
    ){

        login()

    }
}



@Composable
@Preview
fun login(){
    Box(
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxSize()
    ){
        Surface (
            border = BorderStroke(2.dp, color = Color.White),
            modifier = Modifier.size(300.dp,400.dp).align(Alignment.Center)
        ){
            Column(){
                Text("Buenas tardes",Modifier.padding(60.dp).align(alignment = Alignment.CenterHorizontally), fontFamily = FontFamily.SansSerif)
                Text("Buenas tardes",Modifier.padding(60.dp).align(alignment = Alignment.CenterHorizontally), fontFamily = FontFamily.SansSerif)

                Box(
                    modifier = Modifier
                        .padding(30.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .background(color = Color(213,323,4))
                ){
                    Text("Buenas tardes", fontFamily = FontFamily.SansSerif)
                }
            }
        }
    }
}

