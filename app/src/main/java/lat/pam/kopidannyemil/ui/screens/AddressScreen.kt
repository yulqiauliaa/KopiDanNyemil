package lat.pam.kopidannyemil.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddressScreen(
    defaultName: String,
    defaultAddress: String,
    onSubmit: (String) -> Unit
) {
    var fullName by remember { mutableStateOf(defaultName) }
    var address by remember { mutableStateOf(defaultAddress) }
    var detail by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Text("Alamat", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = fullName, onValueChange = { fullName = it },
            label = { Text("Nama Lengkap") }, singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = address, onValueChange = { address = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth().height(110.dp)
        )
        OutlinedTextField(
            value = detail, onValueChange = { detail = it },
            label = { Text("Patokan atau detail lengkap") },
            modifier = Modifier.fillMaxWidth().height(110.dp)
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { onSubmit("$address ($detail)") },
            enabled = fullName.isNotBlank() && address.isNotBlank(),
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) { Text("Order dan Kirim") }
    }
}