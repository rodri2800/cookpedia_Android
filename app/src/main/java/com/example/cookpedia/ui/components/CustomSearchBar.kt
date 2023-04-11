package com.example.cookpedia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.cookpedia.R

@Composable
fun CustomSearchBar() {

    var text:String by remember{
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .clip(
                    shape = AbsoluteRoundedCornerShape(size = 10.dp)
                )
                .background(Color(112, 112, 112, 62))
                .padding(20.dp)

            ,
        ){
            Icon(
                modifier = Modifier.height(24.dp),
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search",
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(12.dp))
            BasicTextField(
                singleLine = true,
                value = text,
                onValueChange = {
                    text = it
                },
                textStyle = TextStyle(
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                ),
            )
        }
    }
}