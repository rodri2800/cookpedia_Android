package com.example.cookpedia.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cookpedia.ui.theme.UrbanistFont

@Composable
fun CustomTitleCatDashboard(title:String){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.W700,
                fontSize = 20.sp
            ),

        )
        Icon(
            Icons.Rounded.ArrowForward,
            contentDescription = "Go to $title",
            tint = Color(0xffF6484A)
        )
    }
}