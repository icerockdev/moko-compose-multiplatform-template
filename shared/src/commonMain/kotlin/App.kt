import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.icerock.moko.graphics.Color as GraphicsColor

@Composable
internal fun App() {

    MaterialTheme {
        var text by remember { mutableStateOf("Hello, World!") }
        var color by remember { mutableStateOf(Color.Black) }
        var isChangeTextFont by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            when (isChangeTextFont) {
                true -> Text(
                    text = text,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = color,
                        fontFamily = FontFamily.Default,
                        fontSize = 30.sp
                    ),
                )
                else -> Text(
                    text = text,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = color,
                        fontFamily = FontFamily(Font(getMokoResourcesFont())),
                        fontSize = 30.sp
                    ),
                )
            }

            Button(
                onClick = {
                    text = getMokoResourcesText()
                }
            ) {
                Text("Get moko text")
            }

            Button(
                onClick = {
                    color = Color(getMokoResourcesColor().argb)
                }
            ) {
                Text("Get moko color")
            }

            Button(
                onClick = {
                    isChangeTextFont = true
                }
            ) {
                Text("Get moko font")
            }
        }
    }
}

expect fun getMokoResourcesText(): String
expect fun getMokoResourcesColor(): GraphicsColor
expect fun getMokoResourcesFont(): Int