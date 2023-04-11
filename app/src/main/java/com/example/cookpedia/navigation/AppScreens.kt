package com.example.cookpedia.navigation

sealed class AppScreens(val route:String, val title:String){
    object PrincipalScreen:AppScreens(route = "principal_screen", title = "Principal")
    object NotificationsScreen:AppScreens(route = "notifications_screen", title = "Notification")
    object BookmarkScreen:AppScreens(route = "bookmark_screen", title = "My Bookmark")
    object HomeScreen:AppScreens(route = "home_screen", title = "Cookpedia")
    object DiscoverScreen:AppScreens(route = "discover_screen", title = "Discover")
    object RecipesScreen:AppScreens(route = "recipes_screen", title = "My Recipes")
    object ProfileScreen:AppScreens(route = "profile_screen", title = "Profile")
    object MealScreen:AppScreens(route = "meal_screen", title = "Meal")
}
