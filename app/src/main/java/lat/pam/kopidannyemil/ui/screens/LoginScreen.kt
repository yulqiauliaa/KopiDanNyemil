package lat.pam.kopidannyemil.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLogin: (username: String, password: String) -> Boolean) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Column(
        Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Text("Login User", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("Akun demo: kopi / 123456", color = Color.Gray, fontSize = 13.sp)
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = username, onValueChange = { username = it; error = null },
            label = { Text("Username") }, singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password, onValueChange = { password = it; error = null },
            label = { Text("Password") }, singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        error?.let { Text(it, color = MaterialTheme.colorScheme.error, fontSize = 13.sp) }

        Spacer(Modifier.weight(1f))
        Button(
            onClick = {
                if (!onLogin(username.trim(), password)) {
                    error = "Username atau password salah"
                }
            },
            enabled = username.isNotBlank() && password.isNotBlank(),
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) { Text("Login") }
    }
}