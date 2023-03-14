import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import org.icerock.template.MR

actual fun getMokoResourcesText(): String = MR.strings.moko_resources_title.localized()

@Composable
fun MainView() = App()

@Preview
@Composable
fun AppPreview() = App()