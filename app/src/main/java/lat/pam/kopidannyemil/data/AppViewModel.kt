package lat.pam.kopidannyemil.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class UserAccount(
    val fullName: String,
    val username: String,
    val email: String,
    val phone: String,
    val password: String,
    val address: String = ""
)

class AppViewModel : ViewModel() {

    private val accounts = mutableStateListOf(
        UserAccount("Pelanggan Kopi", "kopi", "kopi@email.com", "081234567890", "123456")
    )

    var currentUser by mutableStateOf<UserAccount?>(null)
        private set

    var fullAddress by mutableStateOf("")

    val userName: String
        get() = currentUser?.fullName ?: "Nama"

    /** Return null kalau sukses, atau pesan error. */
    fun register(account: UserAccount): String? {
        if (accounts.any { it.username.equals(account.username, ignoreCase = true) }) {
            return "Username sudah dipakai"
        }
        accounts.add(account)
        currentUser = account
        return null
    }

    fun login(username: String, password: String): Boolean {
        val acc = accounts.find {
            it.username.equals(username, ignoreCase = true) && it.password == password
        }
        currentUser = acc
        return acc != null
    }

    fun updateProfile(fullName: String, email: String, phone: String, address: String) {
        val cur = currentUser ?: return
        val updated = cur.copy(fullName = fullName, email = email, phone = phone, address = address)
        val idx = accounts.indexOfFirst { it.username == cur.username }
        if (idx >= 0) accounts[idx] = updated
        currentUser = updated
    }

    fun logout() {
        currentUser = null
        fullAddress = ""
    }
}