import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.foundation.ContextMenuDataProvider
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.SystemColor.text

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
    val Usuario = remember { mutableStateOf("") }
    val Contrasenia = remember { mutableStateOf("") }

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
                ContextMenuDataProvider(
                    items = {
                        listOf(
                            ContextMenuItem("User-defined Action") {/*do something here*/ },
                            ContextMenuItem("Another user-defined action") {/*do something else*/ }
                        )
                    },
                ) {
                    Spacer(Modifier.height(100.dp))

                    TextField(
                        value = Usuario.value,
                        onValueChange = { Usuario.value = it },
                        label = { Text(text = "Usuario")},
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(200.dp,50.dp)
                    )

                    Spacer(Modifier.height(25.dp))
                    Row (
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        var active by remember { mutableStateOf(false) }
                        TextField(
                            value = Contrasenia.value,
                            onValueChange = { Contrasenia.value = it },
                            label = { Text(text = "Contraseña") },
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .size(170.dp, 50.dp),

                            visualTransformation = if (!active) PasswordVisualTransformation() else VisualTransformation.None)//else{VisualTransformation.None}}

                        Button(
                            modifier = Modifier
                                .size(30.dp,30.dp)
                                .align(Alignment.CenterVertically),
                            onClick = {
                            if (!active) active = true else active=false
                        }){  }
                    }
                    Spacer(Modifier.height(25.dp))
                }

                Button(modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                    onClick = {

                    }
                ){
                    Text(" Login ", fontFamily = FontFamily.SansSerif)
                }
            }
        }
    }
}

