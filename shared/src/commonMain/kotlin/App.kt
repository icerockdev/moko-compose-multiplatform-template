import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import dev.icerock.moko.network.features.DynamicUserAgent.Feature.install
import dev.icerock.moko.network.generated.apis.JokesApi
import io.ktor.client.HttpClient
import io.ktor.util.logging.Logger
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

@Composable
internal fun App() {
    val scope = rememberCoroutineScope()
    val jokesApi = JokesApi(
        basePath = "https://api.chucknorris.io", // Base API URL
        httpClient = HttpClient {

        }, // Reference to Ktor HTTP client object
        json = Json {
            ignoreUnknownKeys = true
        } // Reference to kotlinx.serialization.json parser object
    )

    MaterialTheme {
        var text by remember { mutableStateOf("Hello, World!") }

        Button(onClick = {
            text = "Hello, ${getPlatformName()}"
            scope.launch {
                try {
                    val someJoke = jokesApi.getRandomJoke()
                    println("SOME JOKE $someJoke")
                } catch (exception: Exception) {
                    println("ERROR getting jokes $exception")
                }
            }
        }) {
            Text(text)
        }
    }
}

expect fun getPlatformName(): String