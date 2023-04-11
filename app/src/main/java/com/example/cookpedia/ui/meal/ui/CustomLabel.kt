package com.example.cookpedia.ui.meal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cookpedia.ui.theme.PrimaryRedColor

@Composable
fun CustomLabelInfoMeal(type:String, icon:ImageVector, info:String) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(50.dp)
            .clip(
                shape = AbsoluteRoundedCornerShape(12.dp)
            )
            .background(color = PrimaryRedColor.copy(alpha = 0.2F)),
        contentAlignment = Alignment.Center
    ){
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    modifier = Modifier.height(10.dp),
                    imageVector = icon,
                    contentDescription = "$type icon",
                    tint = PrimaryRedColor
                )
                Text(
                    text = info,
                    fontSize = 13.sp,
                    color = PrimaryRedColor,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                text = type,
                color = Color.Gray,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

    }
}