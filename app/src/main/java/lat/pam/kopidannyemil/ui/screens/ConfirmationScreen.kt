package lat.pam.kopidannyemil.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmationScreen(userName: String, onOk: () -> Unit) {
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(Modifier.height(1.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Halo $userName,", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(32.dp))
            Box(
                Modifier.size(100.dp).background(Color(0xFFB8F0D0), CircleShape),
                contentAlignment = Alignment.Center
            ) { Text("OK", fontWeight = FontWeight.Bold, color = Color(0xFF0B6B3A), fontSize = 22.sp) }
            Spacer(Modifier.height(24.dp))
            Text(
                "Terima kasih sudah memesan.\nTunggu aja sebentar kurir kami segera mengantarkan pesananmu!",
                textAlign = TextAlign.Center
            )
        }
        Button(onClick = onOk, modifier = Modifier.fillMaxWidth().height(52.dp)) { Text("Oke") }
    }
}