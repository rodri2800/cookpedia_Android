package com.example.cookpedia.ui.meal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.android.TextLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cookpedia.ui.theme.PrimaryRedColor


@Composable
private fun NumStep(num:Int) {
    Box(
        modifier = Modifier
            .width(30.dp)
            .height(30.dp)
            .clip(
                shape = CircleShape
            )
            .background(color = PrimaryRedColor.copy(alpha = 0.2F)),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "$num",
            color = PrimaryRedColor,
            fontWeight = FontWeight.SemiBold
        )
    }
}



@Composable
fun CustomStepInfo(numstep:Int, description:String) {
    var lineCount by remember {
        mutableStateOf(1)
    }

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = if(lineCount==1) Alignment.CenterVertically else Alignment.Top
    ) {
        NumStep(num = numstep)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = description,
            fontWeight = FontWeight.W600,
            onTextLayout = {
                textLayoutResult: TextLayoutResult ->
                lineCount = textLayoutResult.lineCount
            }
        )
    }
}