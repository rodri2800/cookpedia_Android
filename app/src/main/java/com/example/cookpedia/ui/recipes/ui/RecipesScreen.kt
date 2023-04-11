package com.example.cookpedia.ui.recipes.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.cookpedia.ui.components.customcardmeal.ui.CustomCardMeal
import com.example.cookpedia.ui.loader.LoaderScreen
import com.example.cookpedia.ui.meal.data.Meal


@Composable
private fun BodyContent(navController: NavController?, viewModel: RecipesViewModel = hiltViewModel()) {



    val listMealYourRecipes by viewModel.mealsListYourRecipes.observeAsState()

    val loading by viewModel.isLoading.observeAsState()

    if (loading==true){
        viewModel.getMeals()
        LoaderScreen()
    }else if(loading==false){
        listMealYourRecipes?.let {
            LazyVerticalGrid(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
                columns = GridCells.Adaptive(150.dp),
                content = {
                    items(
                        items = it,
                    ) {
                            item -> CustomCardMeal(
                        meal = item,
                        saved = true,
                        navController = navController,
                    )
                    }
                })
        }
    }



}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipesScreen(navController: NavController) {
    BodyContent(navController)
}