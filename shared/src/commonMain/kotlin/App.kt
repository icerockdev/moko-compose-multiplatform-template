import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
internal fun App() {
    var currentScreen by remember { mutableStateOf(Screen.HelloWorld) }

    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors() else lightColors()
    ) {
        when (currentScreen) {
            Screen.HelloWorld -> HelloWorldScreen(
                onButtonClick = { currentScreen = Screen.SimpleViewModel }
            )

            Screen.SimpleViewModel -> SimpleScreen(
                backAction = { currentScreen = Screen.HelloWorld }
            )
        }
    }
}

expect fun getPlatformName(): String