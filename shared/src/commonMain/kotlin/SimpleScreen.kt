import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SimpleScreen(
    viewModel: SimpleViewModel = remember { SimpleViewModel() }
) {
    val count: String by viewModel.count.collectAsState()
    val jokes: String by viewModel.someJoke.collectAsState()

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //MOKO MVVM
        TextAndButtonTemplate(
            title = count,
            buttonText = "Click and get moko mvvm",
            onButtonClick = viewModel::onCountClick
        )

        //MOKO NETWORK
        TextAndButtonTemplate(
            title = jokes.ifEmpty { "Do you need some jokes?" },
            buttonText = "Click and get moko network",
            onButtonClick = {
                viewModel.apiRequest()
            }
        )
    }
}

@Composable
fun TextAndButtonTemplate(
    title: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Text(
        text = title,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(8.dp))
    Button(onClick = onButtonClick) {
        Text(text = buttonText)
    }
    Spacer(modifier = Modifier.height(10.dp))
}