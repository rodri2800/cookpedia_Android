package com.example.cookpedia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Scale
import com.example.cookpedia.R


@Composable
fun CustomBanner(){
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ){
        AsyncImage(
            modifier = Modifier
                .graphicsLayer {
                    shadowElevation = 25.dp.toPx()
                    ambientShadowColor = Color(252, 23, 42, 255)
                    spotShadowColor = Color(255, 32, 50, 255)
                    clip = true
                }
                .padding(bottom = 5.dp, start = 5.dp, end = 5.dp)
                .align(Alignment.Center)
                .clip(
                    shape = AbsoluteRoundedCornerShape(size = 10.dp)
                )
            ,
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.banner)
                .scale(Scale.FILL)
                .precision(Precision.AUTOMATIC)
                .build(),
            contentDescription = "Banner" )

    }
}