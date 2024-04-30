package listaDeAlumnos




import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.io.File

fun main() = application {
    val windowState = rememberWindowState(size = DpSize(1200.dp,800.dp))
    Window(
        onCloseRequest = ::exitApplication,
        title = "Diego me mata.",
        state = windowState
    ){

        listado()

    }
}

@Composable
@Preview
fun listado() {

    var inputTexto by remember { mutableStateOf("") }

    val ruta = File(System.getProperty("user.dir") + "\\src\\main\\kotlin\\listaDeAlumnos\\estudiantes.txt")

    var lista by remember { mutableStateOf(leer(ruta)) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            aniadirAlumno(
                inputTexto = inputTexto,
                oncambioTexto = { inputTexto = it },
                onAniadirTexto = {
                    if (inputTexto.isNotBlank()) {
                        lista = lista + inputTexto
                        inputTexto = ""
                    }
                }
            )

            Column {
                scroll(items = lista)
                limpiarListado { ruta.writer() }
            }
        }
            Spacer(modifier = Modifier.height(20.dp))

            guardarCambios { escribir(ruta, lista) }





    }
}

@Composable
@Preview
fun aniadirAlumno(
    inputTexto: String,
    oncambioTexto: (String) -> Unit,
    onAniadirTexto: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = inputTexto,
            onValueChange = oncambioTexto,
            label = { Text("Nuevo Elemento") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onAniadirTexto
        ) {
            Text("Agregar a la lista")
        }
    }
}



@Composable
@Preview
fun guardarCambios(onSave:() -> Unit){

    Button(
        onClick = onSave
    ){
        Text("Guardar cambios")
    }
}

@Composable
@Preview
fun limpiarListado(onDelete:() -> Unit){

    Button(
        onClick = onDelete
    ){
        Text("Borrar listados.")
    }
}


fun leer(file: File): List<String> {
    return if (file.exists()) {
        file.readLines()
    } else {
        emptyList()
    }
}


 fun escribir(fichero: File, info: List<String>){
    try {
        info?.forEach {fichero.appendText("$it \n")}
    } catch (e: Exception) {

    }
}
//Hacer con lazy
@Composable
@Preview
fun scroll(items: List<String>){
        Column (
            modifier = Modifier.size(150.dp,200.dp)
                .background(color = Color(180, 180, 180))
                .padding(10.dp)
        ) {

            val state = rememberLazyListState()
            //Creará el scroll asignado y aunque cambie las dimensiones no cambia el espacio
            LazyColumn(Modifier.fillMaxSize().padding(end = 12.dp), state) {
                items(items.size) { x ->
                    TextBox(items[x])
                    Spacer(modifier = Modifier.height(5.dp))
                }

            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.End).fillMaxHeight(),
                adapter = rememberScrollbarAdapter(
                    scrollState = state
                )
            )
        }
    }


@Composable
fun TextBox(text: String) {
    Box(
        modifier = Modifier.height(32.dp)
            .width(400.dp)
            .background(color = Color(200, 0, 0, 20))
            .padding(start = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = text)
    }
}