package com.example.cookpedia.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Scale
import com.example.cookpedia.ui.theme.UrbanistFont
import kotlin.properties.Delegates

private var painterImage by Delegates.notNull<Int>()
private lateinit var nombreCategoria:String
private var cantidadRecetas:Int = 0

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
            .data(painterImage)
            .scale(Scale.FILL)
            .precision(Precision.AUTOMATIC)
            .build(),
        contentDescription = "Imagen comida",
        contentScale = ContentScale.Crop,
    )
}

@Composable
private fun CantidadRecetas() {
    Text(
        text = "$cantidadRecetas recipes",
        style = TextStyle(
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp,
            color = Color.White
        ),
    )
}


@Composable
private fun NameMeal(){
    Text(
        text = nombreCategoria,
        style = TextStyle(
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
            color = Color.White
        ),
    )
}

@Composable
private fun InfoMeal(){
    Column {
        NameMeal()
        Spacer(modifier = Modifier.height(5.dp))
        CantidadRecetas()
    }
}

@Composable
private fun InfoComida(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        InfoMeal()
    }
}



@Composable
fun CustomCardCategories(image: Int, nombre:String, numRecetas:Int, expanded:Boolean?=false) {
    painterImage = image
    nombreCategoria = nombre
    cantidadRecetas = numRecetas

    val modifierCard = when(expanded){
        true -> Modifier.fillMaxWidth().height(150.dp).padding(start = 20.dp, end = 20.dp)
        false, null -> Modifier.width(150.dp).height(100.dp)
    }

    Box(modifier = modifierCard
    ){
        ImagenFondo()
        Box(modifier = Modifier.padding(8.dp)){
            InfoComida()
        }

    }
}