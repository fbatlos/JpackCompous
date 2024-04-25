package ViModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()) {
    //val nameState = viewModel.textFieldState.observeAsState("")
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {
       // MainLayout(
      //      nameState.value
      //  ) { newName -> viewModel.onTextChange(newName) }
    }


}

class MainViewModel(){//: ViewModel() {

    var textFieldState = mutableListOf("")// MutableLiveData("")

    fun onTextChange(newText: String) {
        textFieldState[1] = newText
    }
}

@Composable
fun MainLayout(
    name: String,
    onTextFieldChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = onTextFieldChange
        )
        Text(text = name)
    }
}