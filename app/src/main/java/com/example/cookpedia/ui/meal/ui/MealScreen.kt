package com.example.cookpedia.ui.meal.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Scale
import com.example.cookpedia.R
import com.example.cookpedia.ui.components.CustomInfoCardUser
import com.example.cookpedia.ui.components.CustomSeparator
import com.example.cookpedia.ui.components.CustomTopBarWithButtonBack
import com.example.cookpedia.ui.loader.LoaderScreen
import com.example.cookpedia.ui.meal.data.DetailsMeal
import com.example.cookpedia.ui.meal.domain.datasource.getIngredientList
import com.example.cookpedia.ui.meal.domain.datasource.splitInstructions
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.*


@Composable
private fun Actions(navController: NavController?){
    Row(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(
            painter = painterResource(id = R.drawable.bookmark_border_black_24dp),
            contentDescription = "Bookmark",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier
                .clickable {

                }
                .height(40.dp)
                .width(28.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.detail),
            contentDescription = "Details",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier
                .clickable {
                }
                .height(32.dp),
        )
        Icon(
            painter = painterResource(id = R.drawable.send),
            contentDescription = "Send",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier
                .clickable {

                }
                .height(24.dp),
        )

    }
}

@Composable
private fun ImageHead(strMealThumb: String?) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        model = ImageRequest.Builder(LocalContext.current)
            .data(strMealThumb)
            .precision(Precision.AUTOMATIC)
            .scale(Scale.FILL)
            .crossfade(true)
            .build(),
        placeholder = painterResource(id = R.drawable.defaultmealimage),
        error = painterResource(id = R.drawable.defaultmealimage),
        contentDescription = "Comida",
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun DescriptionMeal(strCategory:String?, strArea:String?) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {

        if (strCategory != null) {
            CustomLabelInfoMeal(
                type = "Category",
                info = strCategory,
                icon = FontAwesomeIcons.Solid.Tags
            )
        }
        if (strArea != null) {
            CustomLabelInfoMeal(
                type = "Area",
                info = strArea,
                icon = FontAwesomeIcons.Solid.MapMarked
            )
        }
    }

}

@Composable
private fun TitleMeal(strMeal: String?) {
    if (strMeal != null) {
        Text(
            text = strMeal,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 50.sp
        )
    }
}

@Composable
private fun TitleSections(title:String) {
    Text(
        modifier = Modifier.padding(vertical = 10.dp),
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}


@Composable
private fun IngredientsSection(ingredients: DetailsMeal?) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TitleSections(title = "Ingredients:")
        ingredients?.let { getIngredientList(it) }?.forEachIndexed {
            index, elememt ->
            CustomStepInfo(numstep = (index+1), description = elememt)
        }
    }
}

@Composable
private fun InstructionsSection(strInstructions: String?) {
    val instrctions = splitInstructions(strInstructions)
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TitleSections(title = "Instructions:")
        instrctions.forEachIndexed { index, element ->
            CustomStepInfo(numstep = (index+1), description = element)
        }
    }
}


@Composable
private fun BodyContent(meal: DetailsMeal?) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        ImageHead(meal?.strMealThumb)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            if (meal != null) {
                TitleMeal(meal.strMeal)
            }
            CustomSeparator()
            CustomInfoCardUser(name = "Jane Cooper", userId = "@jane_cooper"){
                Text(
                    text = "Follow",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
            CustomSeparator()
            DescriptionMeal(strArea = meal?.strArea, strCategory = meal?.strCategory)
            CustomSeparator()
            IngredientsSection(meal)
            CustomSeparator()
            InstructionsSection(meal?.strInstructions)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MealScreen(navController: NavHostController?, idMeal:String,viewModel: MealViewModel = hiltViewModel()) {
    val meal by viewModel.mealInfo.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState()



    Log.d("IdMeal", idMeal)

    if(isLoading==true){
        viewModel.getMeal(idMeal)
        Box(modifier = Modifier.fillMaxSize()){
            LoaderScreen()
        }
    }else if(isLoading==false){
        Scaffold(
            topBar = {
                CustomTopBarWithButtonBack(
                    title = "",
                    navController = navController
                ) {
                    Actions(navController = navController)
                }
            }
        ) {
            BodyContent(meal)
        }
    }


}