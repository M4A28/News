package com.mohmmed.mosa.eg.news.presention.common

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight


@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick ) {
        Text(text = text,
            style = MaterialTheme.typography.
            labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }

}

@Composable
fun NewsTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Text(text = text,
            style = MaterialTheme.typography.
            labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
    
}