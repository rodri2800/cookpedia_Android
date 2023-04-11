package com.example.cookpedia.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Scale
import com.example.cookpedia.R
import com.example.cookpedia.ui.theme.UrbanistFont
import kotlin.properties.Delegates

private var painterImage by Delegates.notNull<Int>()
private lateinit var nombreChef:String

@Composable
private fun ImagenFondo(){
    AsyncImage(
        modifier = Modifier
            .clip(
                shape = AbsoluteRoundedCornerShape(size = 10.dp)
            )
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = size.height / 3,
                    endY = size.height
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Multiply)
                }
            },
        model = ImageRequest.Builder(LocalContext.current)
            .data(R.drawable.perfil)
            .scale(Scale.FILL)
            .precision(Precision.AUTOMATIC)
            .build(),
        contentDescription = "Imagen comida",
        contentScale = ContentScale.Crop,
    )
}


@Composable
private fun NameChef(){
    Text(
        text = nombreChef,
        style = TextStyle(
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
            color = Color.White
        ),
    )
}




@Composable
private fun InfoChef(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NameChef()
    }
}

@Composable
fun CustomCardChef(image:Int, nombre:String) {
    painterImage = image
    nombreChef = nombre
    Box(modifier = Modifier
        .width(150.dp)
        .height(210.dp)

    ){
        ImagenFondo()
        Box(modifier = Modifier.padding(8.dp)){
            InfoChef()
        }

    }
}