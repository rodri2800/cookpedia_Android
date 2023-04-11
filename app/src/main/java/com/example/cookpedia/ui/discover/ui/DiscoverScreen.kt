package com.example.cookpedia.ui.discover.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cookpedia.R
import com.example.cookpedia.ui.components.*
import com.example.cookpedia.ui.components.customcardmeal.ui.CustomCardMeal
import com.example.cookpedia.ui.meal.data.Meal


private val mealPrueba = Meal(
    idMeal = "52874",
    strMeal = "Beef and Mustard Pie",
    strMealThumb = "https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg"
)

@Composable
private fun SectionExample(title:String){
    val scrollStateRow = rememberScrollState()
    Spacer(modifier = Modifier.height(10.dp))
    CustomTitleCatDashboard(title = title)
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.horizontalScroll(scrollStateRow)
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        CustomCardMeal(
            meal = mealPrueba,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CustomCardMeal(
            meal = mealPrueba,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CustomCardMeal(
            meal = mealPrueba,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CustomCardMeal(
            meal = mealPrueba,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CustomCardMeal(
            meal = mealPrueba,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CustomCardMeal(
            meal = mealPrueba,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CustomCardMeal(
            meal = mealPrueba,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CustomCardMeal(
            meal = mealPrueba,
        )
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
private fun ExampleListCategories(title: String) {
    val scrollStateRow = rememberScrollState()
    Spacer(modifier = Modifier.height(10.dp))
    CustomTitleCatDashboard(title = title)
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.horizontalScroll(scrollStateRow)
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        repeat(5) {
            CustomCardCategories(
                image = R.drawable.ensalada,
                nombre = "Ensaladas",
                numRecetas = 16278
            )
            Spacer(modifier = Modifier.width(10.dp))
        }

    }
}


@Composable
private fun ExampleListChefs(title: String) {
    val scrollStateRow = rememberScrollState()
    Spacer(modifier = Modifier.height(10.dp))
    CustomTitleCatDashboard(title = title)
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.horizontalScroll(scrollStateRow)
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        repeat(5){
            CustomCardChef(
                image = R.drawable.perfil,
                nombre = "Natasya")
            Spacer(modifier = Modifier.width(10.dp))
        }


    }
}

@Composable
private fun ShowCategoriesCookpedia(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        SectionExample(title = "Most Popular")
        ExampleListCategories(title = "Recipe Categories")
        ExampleListChefs(title = "Top Chefs")
        SectionExample(title = "Our Recommendations")
        SectionExample(title = "Most Searches")
        SectionExample(title = "New Recipes")
    }
}


@Composable
private fun BodyContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomSearchBar()
        ShowCategoriesCookpedia()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DiscoverScreen(navController: NavController?) {
    BodyContent()
}