import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dev.icerock.moko.graphics.Color
import dev.icerock.moko.resources.desc.desc
import org.icerock.template.MR

@SuppressLint("StaticFieldLeak")
private var context: Context = AppCompatActivity()

actual fun getMokoResourcesText(): String = MR.strings.moko_resources_title.desc().toString(context)
actual fun getMokoResourcesColor(): Color = MR.colors.moko_color_title.color
actual fun getMokoResourcesFont(): Int = MR.fonts.Roboto.bold.fontResourceId


@Composable
fun MainView() {
    context = LocalContext.current
    App()
}
