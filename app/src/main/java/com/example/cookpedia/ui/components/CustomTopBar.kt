package com.example.cookpedia.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.cookpedia.R
import com.example.cookpedia.ui.theme.UrbanistFont

@Composable
private fun TitleAppWithBack(title: String, navController: NavController?) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            modifier = Modifier.height(30.dp)
                .clickable {
                           navController?.popBackStack()
                },
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Back",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = title,
            style = TextStyle(
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.W700,
                fontSize = 20.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
    }
}

@Composable
private fun TitleApp(title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            modifier = Modifier.height(30.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.logo)
                .scale(Scale.FILL)
                .build(),
            contentDescription = "Logo Cookpedia"
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = title,
            style = TextStyle(
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.W700,
                fontSize = 20.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
    }
}

@Composable
fun CustomTopBar(title:String, navController: NavController?=null, actions:@Composable BoxScope.() -> Unit){
    TopAppBar(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            TitleApp(title=title)
            Box(content = actions)
        }
    }
}


@Composable
fun CustomTopBarWithButtonBack(title:String, navController: NavController?=null, actions:@Composable BoxScope.() -> Unit){
    TopAppBar(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            TitleAppWithBack(title=title, navController = navController)
            Box(content = actions)
        }
    }
}