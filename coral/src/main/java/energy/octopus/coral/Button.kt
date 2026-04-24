package energy.octopus.coral

import androidx.compose.runtime.Composable

@Composable
fun Button(text: String, onClick : () -> Unit) {
    Button(text = text, onClick = {onClick()})
}