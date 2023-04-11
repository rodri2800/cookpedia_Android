package com.example.cookpedia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cookpedia.R
import com.example.cookpedia.ui.theme.UrbanistFont

@Composable
private fun UserImage(image:Painter, read: Boolean?) {
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
    ){
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    shape = CircleShape
                ),
            painter = image,
            contentDescription = "Perfil",
            contentScale = ContentScale.Crop
        )
        if (read == false){
            Box(
                modifier = Modifier
                    .width(12.dp)
                    .height(12.dp)
                    .clip(
                        shape = CircleShape
                    )
                    .background(color = if (isSystemInDarkTheme()) Color.Black else Color.White)
                    .align(Alignment.BottomEnd)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp)
                        .clip(
                            shape = CircleShape
                        )
                        .background(color = Color(245, 72, 74))
                )
            }
        }
    }

}

@Composable
private fun Info(name:String, action: String, day: Int, time: String) {
    val textDay:String = if(day==0){
        "Today"
    }else if(day>0){
        "$day day ago"
    }
    else if (day<0){
        "Sin info"
    }else{
        "Sin info"
    }
    Column(
    ) {
        Text(
            text = "$name $action",
            maxLines = 2,
            style = TextStyle(
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.W600,
                fontSize = 16.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$textDay | $time",
            maxLines = 1,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp,
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.W500,
            )
        )
    }
}

@Composable
private fun MenuOptions() {
    Icon(
        modifier = Modifier
            .height(24.dp),
        painter = painterResource(id = R.drawable.menu_dots_vertical),
        contentDescription = "Options" )
}

@Composable
private fun ImageMeal(image:Painter) {
    Image(
        modifier = Modifier
            .width(68.dp)
            .height(68.dp)
            .clip(
                shape = AbsoluteRoundedCornerShape(8.dp)
            ),
        painter = image,
        contentDescription = "Meal",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun CustomCardGeneralNotification(
    userImage:Painter,
    userName:String,
    day:Int,
    time:String,
    mealImage:Painter,
    read:Boolean?=false,
    action:String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()

            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 10.dp,
                bottom = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserImage(image = userImage, read = read)
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier.weight(1F)
        ){
            Info(name = userName, action = action, day = day, time = time)
        }
        Spacer(modifier = Modifier.width(12.dp))
        ImageMeal(image = mealImage)
        Spacer(modifier = Modifier.width(12.dp))
        MenuOptions()
    }

}