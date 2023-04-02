import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SimpleViewModel : ViewModel() {
    private val _count: MutableStateFlow<Int> = MutableStateFlow(0)
    val count: StateFlow<Int> get() = _count

    fun onCountClick() {
        _count.update { it + 1 }
    }
}
