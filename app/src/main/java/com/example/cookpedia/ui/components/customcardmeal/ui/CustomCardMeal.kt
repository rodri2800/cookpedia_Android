package com.example.cookpedia.ui.components.customcardmeal.ui

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Scale
import com.example.cookpedia.R
import com.example.cookpedia.navigation.AppScreens
import com.example.cookpedia.ui.meal.data.Meal
import com.example.cookpedia.ui.theme.UrbanistFont
import com.valentinilk.shimmer.shimmer
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.Bookmark
import compose.icons.fontawesomeicons.solid.Bookmark
import kotlinx.coroutines.coroutineScope

private var infoMeal: Meal? = null
private val savedMeal:MutableLiveData<Int> by lazy {
    MutableLiveData<Int>(0)
}

@Composable
private fun ImagenFondo(){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(infoMeal!!.strMealThumb)
            .precision(Precision.AUTOMATIC)
            .scale(Scale.FILL)
            .crossfade(true)
            .build(),
        placeholder = painterResource(id = R.drawable.defaultmealimage),
        error = painterResource(id = R.drawable.defaultmealimage),
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
        contentDescription = "Imagen comida",
        contentScale = ContentScale.Crop,
    )
}

@Composable
private fun ButtonAdd(onClick: ()-> Unit, saved: Boolean?) {


    Box(modifier = Modifier
        .clip(CircleShape)
        .background(color = Color(0xffF6484A))
        .width(30.dp)
        .height(30.dp)
        .clickable(
            onClick = onClick
        )
    ){
        Icon(
            modifier = Modifier
                .align(Alignment.Center)
                .width(12.dp),
            imageVector = if (saved == true) FontAwesomeIcons.Solid.Bookmark else FontAwesomeIcons.Regular.Bookmark,
            contentDescription = null,
            tint = Color(0xFFFFFFFF)
        )
    }
}

@Composable
private fun NameMeal(){
    Text(
        text = infoMeal!!.strMeal,
        style = TextStyle(
            fontFamily = UrbanistFont,
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
            color = Color.White
        ),
    )
}

@Composable
private fun UserInfo(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.perfil)
                .scale(Scale.FILL)
                .precision(Precision.AUTOMATIC)
                .build(),
            contentDescription = "Perfil",
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Jane Cooper",
            style = TextStyle(
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.W600,
                fontSize = 11.sp,
                color = Color.White
            ),
        )
    }
}

@Composable
private fun InfoMeal(){
    Column {
        NameMeal()
        UserInfo()
    }
}

@Composable
private fun InfoComida(saved:Boolean, viewModel: CustomCardMealViewModel, onClick: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            ButtonAdd(onClick= onClick, saved= saved)
        }
        InfoMeal()
    }
}


@Composable
fun CustomCardMealLoader() {
    Box(
        modifier = Modifier.shimmer()
            .clip(
            shape = AbsoluteRoundedCornerShape(size = 10.dp)
        )
    ){
        Box(
            modifier = Modifier.width(150.dp)
                .height(210.dp)
                .background(Color.Gray)
        )
    }
}



@Composable
fun CustomCardMeal(meal:Meal, saved:Boolean? = false, navController: NavController? =null, viewModel: CustomCardMealViewModel = hiltViewModel()){
    infoMeal = meal

    val savedMeal by viewModel.saved.observeAsState()

    viewModel.consultAddOnBD(meal.idMeal)

    //Log.d("Registred Meal", savedMeal?.get(Integer.parseInt(meal.idMeal)).toString())

    Box(modifier = Modifier
        .width(150.dp)
        .height(210.dp)
        .clickable {
            navController.let {
                navController?.navigate(AppScreens.MealScreen.route + "/${meal.idMeal}")
            }
        }

    ){
        ImagenFondo()
        Box(modifier = Modifier.padding(8.dp)){
            InfoComida(viewModel = viewModel, saved = savedMeal?.get(Integer.parseInt(meal.idMeal))==true){
                viewModel.buttonSaveMeal(meal)
                //Log.d("Prueba", meal.toString())
            }
        }

    }
}
