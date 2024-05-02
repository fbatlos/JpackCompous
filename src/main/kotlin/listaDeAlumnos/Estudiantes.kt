package listaDeAlumnos

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.delay
import java.io.File


@Composable
@Preview
fun listado() {
    val file = File()

    val newStudentFocusRequester = remember { FocusRequester()}

    var showInfo by remember { mutableStateOf(false) }

    var mensajeInfo by remember { mutableStateOf("") }

    var inputTexto by remember { mutableStateOf("") }

    val ruta = File(System.getProperty("user.dir") + "\\src\\main\\kotlin\\listaDeAlumnos\\estudiantes.txt")

    var lista by remember { mutableStateOf(file.leer(ruta)) }

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
                    showInfo = true
                    mensajeInfo = "Se añadio un alumno."
                },
                focusRequester = newStudentFocusRequester
            )

            Column {
                scroll(items = lista, onItemClick = {

                    lista = lista.toMutableList().apply { removeAt(it)}
                    ruta.writer()
                    file.escribir(ruta,lista)
                    showInfo = true
                    mensajeInfo = "Alumno elimminado."

                }, requester = newStudentFocusRequester)
                limpiarListado (
                    onDelete = {ruta.writer()
                    lista = file.leer(ruta)
                    showInfo = true
                    mensajeInfo = "Lista limpiada."},
                    requester = newStudentFocusRequester

                )

            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        guardarCambios (onSave = {
            ruta.writer()
            file.escribir(ruta, lista)
            showInfo = true
            mensajeInfo = "Se guardo la lista."
        }, requester = newStudentFocusRequester)


    }

    if (showInfo) {
        InfoMessage(
            mensaje = mensajeInfo,
            onDismmis = {
                showInfo=false
                mensajeInfo = ""
                newStudentFocusRequester.requestFocus()
            }
        )
    }

    LaunchedEffect(showInfo) {
        if (showInfo) {
            delay(2000)
            showInfo=false
            mensajeInfo = ""
            newStudentFocusRequester.requestFocus()
        }
    }
}

@Composable
@Preview
fun aniadirAlumno(
    inputTexto: String,
    oncambioTexto: (String) -> Unit,
    onAniadirTexto: () -> Unit,
    focusRequester: FocusRequester
) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            modifier = Modifier.focusRequester(focusRequester),
            value = inputTexto,
            onValueChange = oncambioTexto,
            label = { Text("Nuevo Elemento") }

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
fun guardarCambios(onSave:() -> Unit,requester: FocusRequester){

    Button(
        onClick = onSave
    ){
        Text("Guardar cambios")
    }
}

@Composable
@Preview
fun limpiarListado(onDelete:() -> Unit , requester: FocusRequester){

    Button(
        onClick = onDelete
    ){
        Text("Borrar listados.")
    }
}

//Hacer con lazy
@Composable
@Preview
fun scroll(items: List<String>, onItemClick: (Int) -> Unit,requester: FocusRequester){
    Text("Estudiantes : ${items.size}")
    Column (
        modifier = Modifier.size(250.dp,400.dp)
            .border(3.dp, Color.Black)
            .padding(10.dp)
    ) {

        val state = rememberLazyListState()


        //Creará el scroll asignado y aunque cambie las dimensiones no cambia el espacio
        LazyColumn(Modifier.fillMaxSize().padding(end = 10.dp), state) {
            items(items.size) { x ->
                TextBox(items[x] , onClick = { onItemClick(x) })

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
fun TextBox(text: String, onClick: () -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = { /* No se necesita hacer nada aquí */ },
        enabled = false,
        trailingIcon = {
            IconButton(
                enabled = true,
                onClick = onClick // Solo pasa la función onClick, no la llames
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar estudiantes.")
            }
        }
    )
}

@Composable
fun InfoMessage(mensaje: String,onDismmis:() -> Unit){
    Dialog(
        icon = painterResource("sample.png"),
        title = "hola",
        resizable = false,
        onCloseRequest = onDismmis
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ){
            Text(mensaje)
        }
    }
}

