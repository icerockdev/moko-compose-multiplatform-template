import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.network.generated.apis.JokesApi
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class SimpleViewModel : ViewModel() {
    private val _count: MutableStateFlow<String> = MutableStateFlow("Click on button")
    private val _someJoke: MutableStateFlow<String> = MutableStateFlow("")
    val count: StateFlow<String> = _count
    val someJoke: StateFlow<String> = _someJoke

    private val jokesApi = JokesApi(
        basePath = "https://api.chucknorris.io/jokes/", // Base API URL
        httpClient = HttpClient(), // Reference to Ktor HTTP client object
        json = Json {
            ignoreUnknownKeys = true
        } // Reference to kotlinx.serialization.json parser object
    )

    fun onJokePress() {
        viewModelScope.launch {
            try {
                val response = jokesApi.getRandomJoke()
                _someJoke.value = response.value
            } catch (error: Exception) {
                println("MOKO NETWORK error $error")
            }
        }
    }

    fun onCountClick() {
        _count.value = "WEll done, moko mvvm is work"
    }
}