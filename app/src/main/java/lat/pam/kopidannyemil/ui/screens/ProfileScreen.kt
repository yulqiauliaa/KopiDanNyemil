package lat.pam.kopidannyemil.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lat.pam.kopidannyemil.data.UserAccount

@Composable
fun ProfileScreen(
    user: UserAccount,
    onSave: (fullName: String, email: String, phone: String, address: String) -> Unit,
    onLogout: () -> Unit,
    onHome: () -> Unit
) {
    val context = LocalContext.current
    var fullName by remember(user) { mutableStateOf(user.fullName) }
    var email by remember(user) { mutableStateOf(user.email) }
    var phone by remember(user) { mutableStateOf(user.phone) }
    var address by remember(user) { mutableStateOf(user.address) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            Modifier.size(96.dp).background(Color(0xFF6F4E37), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                user.fullName.take(1).uppercase(),
                color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold
            )
        }
        Text("Halo ${user.fullName},", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("@${user.username}", color = Color.Gray)

        Spacer(Modifier.height(8.dp))
        Text(
            "Profile Setting",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = fullName, onValueChange = { fullName = it },
            label = { Text("Nama lengkap") }, singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = user.username, onValueChange = {},
            label = { Text("Username") }, singleLine = true, enabled = false,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text("Email") }, singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = phone, onValueChange = { phone = it.filter { c -> c.isDigit() } },
            label = { Text("No. HP") }, singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = address, onValueChange = { address = it },
            label = { Text("Alamat utama") },
            modifier = Modifier.fillMaxWidth().height(100.dp)
        )

        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                onSave(fullName.trim(), email.trim(), phone, address.trim())
                Toast.makeText(context, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
            },
            enabled = fullName.isNotBlank() && email.isNotBlank() && phone.isNotBlank(),
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) { Text("Save") }

        OutlinedButton(
            onClick = onHome,
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) { Text("Kembali ke Home") }

        TextButton(onClick = onLogout) {
            Text("Logout", color = MaterialTheme.colorScheme.error)
        }
    }
}