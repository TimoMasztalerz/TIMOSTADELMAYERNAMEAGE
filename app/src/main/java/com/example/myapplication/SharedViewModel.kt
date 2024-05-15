import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// SharedViewModel.kt
class SharedViewModel : ViewModel() {
    private val _Daten = MutableLiveData<String>()
    val Daten: LiveData<String> = _Daten

    fun updateData(newData: String) {
        _Daten.value = newData
    }
}