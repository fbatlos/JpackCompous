package Student

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
/**
@Composable
fun StudentList() {
    val students = remember { mutableStateListOf("Juan", "Victor", "Esther", "Jaime")}
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (student in students) {
            StudentText(name = student)
        }
        Button(
            onClick = { if (!students.contains("Miguel")) (students.add( "Miguel"))  },
        ) {
            Text(text = "Add new student")
        }
    }
}

*/

@Composable
fun StudentList(students: List<String>, onButtonClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for(student in students) {
            StudentText(name = student)
        }
        Button(
            onClick = onButtonClick,
        ) {
            Text(text = "Add new student")
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
        val students = remember { mutableStateListOf("Juan", "Victor", "Esther", "Jaime")}
        StudentList(students){
            if (!students.contains("Miguel")) (students.add( "Miguel"))
        }

    }
}