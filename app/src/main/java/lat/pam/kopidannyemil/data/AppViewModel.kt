package lat.pam.kopidannyemil.data

package lat.pam.kopidannyemil.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
    var userName by mutableStateOf("Nama")
    var fullAddress by mutableStateOf("")

    fun login(username: String) {
        userName = username
    }
}