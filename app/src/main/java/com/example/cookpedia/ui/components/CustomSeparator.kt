package com.example.cookpedia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomSeparator() {
    Spacer(
        modifier = Modifier.height(21.dp)
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .background(Color.Gray.copy(alpha = 0.3F))

    )
}