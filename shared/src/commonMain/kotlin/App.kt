import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.icerock.moko.graphics.Color as GraphicsColor

@Composable
internal fun App() {

    MaterialTheme {
        var text by remember { mutableStateOf("Hello, World!") }
        var isShowColorSpace by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                textAlign = TextAlign.Center,
                text = text
            )

            if (isShowColorSpace) {
                Spacer(
                    modifier = Modifier
                        .background(Color(getMokoResourcesColor().argb))
                        .width(100.dp)
                        .height(50.dp)
                )
            }

            Button(
                onClick = {
                    text = getMokoResourcesText()
                }
            ) {
                Text("Get moko text")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    isShowColorSpace = true
                }
            ) {
                Text("Get moko color")
            }
        }
    }
}

expect fun getMokoResourcesText(): String
expect fun getMokoResourcesColor(): GraphicsColor