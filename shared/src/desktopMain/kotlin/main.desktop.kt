import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Desktop"

@Composable fun MainView() = App(viewModel)

@Preview
@Composable
fun AppPreview() {
    App(viewModel)
}