package com.example.healthyfitness.presentation.screens.common_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowItem(ob: String, name: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(text = name, style = MaterialTheme.typography.bodyLarge, color = Color.White)
        Text(ob, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onTertiary)
    }
}