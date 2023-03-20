import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
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
        var currentScreen: Screen by remember { mutableStateOf(Screen.HelloWorld) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
}

expect fun getPlatformName(): String
