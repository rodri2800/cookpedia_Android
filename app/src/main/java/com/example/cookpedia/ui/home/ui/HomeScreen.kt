package com.example.cookpedia.ui.home.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cookpedia.ui.components.*
import com.example.cookpedia.ui.components.customcardmeal.ui.CustomCardMeal
import com.example.cookpedia.ui.components.customcardmeal.ui.CustomCardMealLoader
import com.example.cookpedia.ui.meal.data.Meal

@Composable
fun HomeScreen(navController: NavController?){
    BodyContent(navController = navController)
}

private val mealPrueba = Meal(
    idMeal = "53035",
    strMeal = "Jamaican Beef Patties",
    strMealThumb = "https://www.themealdb.com/images/media/meals/wsqqsw1515364068.jpg"
)

@Composable
private fun SectionExample(title:String, navController: NavController?, listMeal: List<Meal>?){
    val scrollStateRow = rememberScrollState()
    Spacer(modifier = Modifier.height(10.dp))
    CustomTitleCatDashboard(title = title)
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.horizontalScroll(scrollStateRow)
    ) {
        Spacer(modifier = Modifier.width(20.dp))

        Log.d("Listas: ", listMeal.toString())

        if (listMeal != null) {
            if(listMeal.isEmpty()){
                repeat(10){
                    CustomCardMealLoader()
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }else{
                listMeal.forEach{ element ->
                    CustomCardMeal(
                        meal = element,
                        navController = navController,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

        }else{
            repeat(10){
                CustomCardMealLoader()
                Spacer(modifier = Modifier.width(10.dp))
            }
        }



    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun BodyContent(navController: NavController?, viewModel: HomeViewModel = hiltViewModel()){

    viewModel.getMeals()


    val listMealRecentRecipes by viewModel.mealsListRecentRecipes.observeAsState()
    val listMealYourRecipes by viewModel.mealsListYourRecipes.observeAsState()
    val listMealBookmark by viewModel.mealsListBookmark.observeAsState()


    val scrollStateColumn = rememberScrollState()

    Scaffold(
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollStateColumn)
        ){
            Spacer(modifier = Modifier.height(10.dp))
            CustomBanner()
            SectionExample(
                title = "Recent Recipes",
                navController = navController,
                listMeal = listMealRecentRecipes)
            SectionExample(
                title = "Your Recipes",
                navController = navController,
                listMeal = listMealYourRecipes)
            SectionExample(
                title = "Your Bookmark",
                navController = navController,
                listMeal = listMealBookmark)
        }
    }

}



@Composable
@Preview

fun DefaulPreview(){
    HomeScreen(navController = null)
}