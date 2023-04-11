package com.example.cookpedia.ui.bookmark.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cookpedia.R
import com.example.cookpedia.navigation.AppScreens
import com.example.cookpedia.ui.components.customcardmeal.ui.CustomCardMeal
import com.example.cookpedia.ui.components.CustomTopBarWithButtonBack
import com.example.cookpedia.ui.loader.LoaderScreen
import com.example.cookpedia.ui.meal.data.Meal



@Composable
private fun BodyContent(navController: NavController?, items:List<Meal>) {
    LazyVerticalGrid(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
        columns = GridCells.Adaptive(150.dp),
        content = {
            items(
                items = items,
            ) {
                item -> CustomCardMeal(
                meal = item,
                saved = true,
                navController = navController
            )
            }
        })
}

@Composable
private fun Actions(navController: NavController?){
    Row {
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "Search",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier
                .clickable {

                }
                .width(24.dp),
        )

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BookmarkScreen(navController: NavController?, viewModel: BookmarkViewModel = hiltViewModel()){

    val meals by viewModel.meals.observeAsState()

    Scaffold(
        topBar = {
            CustomTopBarWithButtonBack(
                title = AppScreens.BookmarkScreen.title,
                navController = navController
            ) {
                Actions(navController = navController)
            }
        }
    ) {
        if (meals==null){
            LoaderScreen()
        }else if(meals!!.isEmpty()){
            Text(text = "No tienes agregadas")
        }else{
            BodyContent(navController = navController, items = meals!!)
        }

    }
}