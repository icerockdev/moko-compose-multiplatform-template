import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SimpleViewModel : ViewModel() {
    private val _count: MutableStateFlow<String> = MutableStateFlow("Click on button")
    val count: StateFlow<String> = _count

    fun onCountClick() {
        _count.value = "WEll done, moko mvvm is work"
    }
}