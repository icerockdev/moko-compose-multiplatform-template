import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.myapplication.common.MR
import dev.icerock.moko.resources.desc.desc

@SuppressLint("StaticFieldLeak")
private var context: Context = AppCompatActivity()

actual fun getMokoResourcesText(): String = MR.strings.moko_resources_title.desc().toString(context)


@Composable
fun MainView() {
    context = LocalContext.current
    App()
}
