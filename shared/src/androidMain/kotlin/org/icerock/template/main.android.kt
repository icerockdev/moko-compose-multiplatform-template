import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dev.icerock.moko.resources.desc.desc
import org.icerock.template.MR

@SuppressLint("StaticFieldLeak")
private var context: Context = AppCompatActivity()

actual fun getMokoResourcesText(): String = MR.strings.moko_resources_title.desc().toString(context)


@Composable
fun MainView() {
    context = LocalContext.current
    App()
}
