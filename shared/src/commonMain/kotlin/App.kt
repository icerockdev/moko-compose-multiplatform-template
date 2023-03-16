import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun App() {
    MaterialTheme {
        var text by remember { mutableStateOf("Hello, World!") }
        var isShowMokoMvvmView by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (!isShowMokoMvvmView) {
                Button(
                    onClick = {
                        text = "Hello, ${getPlatformName()}"
                    }
                ) {
                    Text(text)
                }

                Button(
                    onClick = {
                        isShowMokoMvvmView = true
                    }
                ) {
                    Text("Show moko mvvm engines")
                }
            } else {
                SimpleScreen()
            }
        }
    }
}

expect fun getPlatformName(): String