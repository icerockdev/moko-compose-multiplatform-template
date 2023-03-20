import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun HelloWorldScreen(
    onButtonClick: () -> Unit
) {
    var text by remember { mutableStateOf("Hello, World!") }

    Button(
        onClick = {
            text = "Hello, ${getPlatformName()}"
        }
    ) {
        Text(text)
    }

    Button(
        onClick = onButtonClick
    ) {
        Text("Show moko mvvm")
    }
}
