import androidx.compose.ui.window.ComposeUIViewController

actual fun getPlatformName(): String = "IOS"

fun MainViewController() = ComposeUIViewController { App() }