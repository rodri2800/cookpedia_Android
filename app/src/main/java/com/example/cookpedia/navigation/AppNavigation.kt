package com.example.cookpedia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cookpedia.ui.bookmark.ui.BookmarkScreen
import com.example.cookpedia.ui.notifications.ui.NotifitationsScreen
import com.example.cookpedia.ui.meal.ui.MealScreen
import com.example.cookpedia.ui.principal.ui.PrincipalScreen


@Composable
fun AppNavigation(navController: NavHostController){

    NavHost(navController = navController, startDestination = AppScreens.PrincipalScreen.route){
        composable(route = AppScreens.PrincipalScreen.route){
            PrincipalScreen(navController = navController)
        }
        composable(route = AppScreens.NotificationsScreen.route){
            NotifitationsScreen(navController = navController)
        }
        composable(route = AppScreens.BookmarkScreen.route){
            BookmarkScreen(navController = navController)
        }
        composable(route = AppScreens.MealScreen.route + "/{idMeal}",
        arguments = listOf(navArgument(name = "idMeal"){
            type = NavType.StringType
        })
        ){
            it.arguments?.getString("idMeal")
                ?.let { it1 -> MealScreen(navController = navController, idMeal = it1) }
        }
    }
}