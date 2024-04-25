package Ventanas

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val icon = BitmapPainter(useResource("sample.png", ::loadImageBitmap))
    var showMainWindow by remember { mutableStateOf(true) }
    var showSecondWindow by remember { mutableStateOf(false) }

    when {
        showMainWindow -> {
            showMainWindow(onClose ={showMainWindow=false}, onSecondWindow = {
                showSecondWindow=true
                showMainWindow=false
            })
        }
        showSecondWindow ->{
            SecondaryWindow(onClose = {showSecondWindow=false}, onVolver = {
                showMainWindow=true
                showSecondWindow=false
            })


        }
    }

    if (!showMainWindow && !showSecondWindow) {
        exitApplication()
    }
}

@Composable
fun SecondaryWindow(onClose: () -> Unit,onVolver:()->Unit) {
    val secondaryWindowState = rememberWindowState()
    Window(
        onCloseRequest = onClose,
        title = "Ventana Secundaria",
        state = secondaryWindowState
    ) {

        Button(onClick = onVolver) {
            Text("Abrir Ventana Primaria y cerrar esta")
        }
    }
}


@Composable
fun showMainWindow(onClose: () -> Unit,onSecondWindow:() ->  Unit){//,onOpenSecond:()-> Unit){
    val firstWindowState = rememberWindowState()
    Window(
        onCloseRequest = onClose,
        title = "Ventana Primaria",
        state = firstWindowState
    ) {

        Button(onClick = onSecondWindow){
            Text("Abrir Ventana Segundaria y cerrar esta")
        }
    }
}
