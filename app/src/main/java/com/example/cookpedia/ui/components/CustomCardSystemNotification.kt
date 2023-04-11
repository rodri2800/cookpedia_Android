package com.example.cookpedia.ui.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cookpedia.ui.notifications.data.Notification
import com.example.cookpedia.ui.theme.UrbanistFont

@Composable
private fun CustomIcon(tipo: Notification) {
    Box(
        modifier = Modifier
            .width(45.dp)
            .height(45.dp)
            .clip(
                shape = CircleShape
            )
            .background(tipo.color.copy(alpha = 0.2F))
            .padding(12.dp)
    ){
        Icon(
            painter = painterResource(id = tipo.icon),
            contentDescription = "Icon notification",
            tint = tipo.color
        )
    }
}

@Composable
private fun InfoNotification(title: String, day: Int, time: String) {
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
            text = title,
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
private fun EtiquetaNew() {
    Box(
        modifier = Modifier
            .clip(
                shape = AbsoluteRoundedCornerShape(6.dp)
            )
            .background(Color(245, 72, 74))
            .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
    ){
        Text(
            text = "New",
            maxLines = 1,
            style = TextStyle(
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.W600,
            )
        )
    }
}

@Composable
fun CustomCardSystemNotification(notificationType: Notification, title:String, read:Boolean?=false, information:String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 10.dp,
                bottom = 10.dp
            )
    ) {
        //Encabezado
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIcon(tipo = notificationType)
            Spacer(modifier = Modifier.width(12.dp))
            //Info
            Box(
                modifier = Modifier.weight(1F)
            ){
                InfoNotification(
                    title = title,
                    day = 0,
                    time = "10:15 AM"
                )
            }
            //FIN INFO
            if (read==false){
                Spacer(modifier = Modifier.width(12.dp))
                EtiquetaNew()
            }

        }
        //FIN ENCABAZADO
        Spacer(modifier = Modifier.height(12.dp))
        //Information
        Text(text = information)
    }
}