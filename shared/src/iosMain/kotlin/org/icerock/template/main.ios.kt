import androidx.compose.ui.window.ComposeUIViewController
import dev.icerock.moko.graphics.Color
import dev.icerock.moko.resources.desc.desc
import org.icerock.template.MR

actual fun getMokoResourcesText(): String = MR.strings.moko_resources_title.desc().localized()
actual fun getMokoResourcesColor(): Color = MR.colors.moko_color_title.color

fun MainViewController() = ComposeUIViewController { App() }