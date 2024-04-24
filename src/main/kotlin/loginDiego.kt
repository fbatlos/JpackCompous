import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.DpSize
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
fun Usuario(Usuario:String, onUsuarioChange: (String) -> Unit){
    Spacer(Modifier.height(100.dp))
    OutlinedTextField(
        value = Usuario,
        onValueChange = onUsuarioChange,
        label = { Text(text = "Usuario") },
        modifier = Modifier
            .size(200.dp, 60.dp)
    )
    Spacer(Modifier.height(25.dp))
}

@Composable
fun Contrasenia(Contrasenia: String, onContraseniaChange: (String) -> Unit){
    var active by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = Contrasenia,
        onValueChange = onContraseniaChange,
        label = { Text(text = "Contraseña") },
        modifier = Modifier
            .size(170.dp, 60.dp),

        visualTransformation = if (!active) PasswordVisualTransformation() else VisualTransformation.None,
    )
    Button(
        modifier = Modifier
            .size(30.dp, 30.dp),
        onClick = {
            if (!active) active = true else active = false
        }) { }
}

@Composable
fun BottonLogin(Usuario: String,Contrasenia: String,onBotonChange:(String) -> Unit){
    Spacer(Modifier.height(25.dp))
    Button(
        onClick = {
            onBotonChange(Usuario)
            onBotonChange(Contrasenia)
        }) {
        Text(" Login ", fontFamily = FontFamily.SansSerif)
    }
}

@Composable
@Preview
fun login() {
    var Usuario by remember { mutableStateOf("") }

    var Contrasenia by remember { mutableStateOf("") }

    Box(

        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxSize()

    ) {
        Surface(
            border = BorderStroke(2.dp, color = Color.White),
            modifier = Modifier.size(300.dp, 400.dp).align(Alignment.Center)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Usuario(Usuario){
                    Usuario=it
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {

                    Contrasenia(Contrasenia){
                        Contrasenia = it
                    }
                       // trailingIcon = {}
                    //cambiar button por un trailingIcon.
                }

                BottonLogin(Usuario,Contrasenia){
                    Usuario = ""
                    Contrasenia=""
                }

            }
        }
    }
}
