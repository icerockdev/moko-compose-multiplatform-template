import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.icerock.template.MR

@Composable
actual fun getMokoResourcesText(): String = stringResource(MR.strings.moko_resources_title.resourceId)

@Composable fun MainView() = App()
