package energy.octopus.coral

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CButton(text: String, onClick : () -> Unit) {
    Button(
        onClick = onClick,
    ) { Text(text) }
}