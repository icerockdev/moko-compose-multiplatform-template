import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun App() {
    val appViewModel: AppViewModel =
        getViewModel(key = "app", klass = AppViewModel::class) { AppViewModel() }
    val currentScreen: Screen by appViewModel.currentScreen.collectAsState()

    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors() else lightColors()
    ) {
        when (currentScreen) {
            Screen.HelloWorld -> HelloWorldScreen(
                onButtonClick = { appViewModel.currentScreen.value = Screen.SimpleViewModel }
            )

            Screen.SimpleViewModel -> SimpleScreen(
                backAction = { appViewModel.currentScreen.value = Screen.HelloWorld }
            )
        }
    }
}

class AppViewModel : ViewModel() {
    val currentScreen: MutableStateFlow<Screen> = MutableStateFlow(Screen.HelloWorld)

    init {
        println("create $this")
    }

    override fun onCleared() {
        super.onCleared()
        println("clear $this")
    }
}

expect fun getPlatformName(): String