import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
internal fun App() {
    MaterialTheme {
        var currentScreen: Screen by remember { mutableStateOf(Screen.HelloWorld) }

        when (currentScreen) {
            Screen.HelloWorld -> HelloWorldScreen(
                onButtonClick = {
                    currentScreen = Screen.SimpleViewModel
                }
            )
            Screen.SimpleViewModel -> SimpleScreen()
        }
    }
}

expect fun getPlatformName(): String
