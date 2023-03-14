import androidx.compose.runtime.Composable
import dev.icerock.moko.graphics.Color
import org.icerock.template.MR

actual fun getMokoResourcesText(): String = MR.strings.moko_resources_title.localized()
actual fun getMokoResourcesColor(): Color = MR.colors.moko_color_title.color
actual fun getMokoResourcesFont(): Int? = MR.fonts.Roboto.bold.font.style

@Composable
fun MainView() = App()
