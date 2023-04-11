package com.example.cookpedia.ui.principal.ui

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Down
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Up
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cookpedia.R
import com.example.cookpedia.navigation.AppScreens
import com.example.cookpedia.ui.components.CustomTopBar
import com.example.cookpedia.ui.discover.ui.DiscoverScreen
import com.example.cookpedia.ui.discover.ui.TopBarActionsDiscoverScreen
import com.example.cookpedia.ui.home.ui.HomeScreen
import com.example.cookpedia.ui.home.ui.TopBarActionsHomeScreen
import com.example.cookpedia.ui.profile.ui.ProfileScreen
import com.example.cookpedia.ui.profile.ui.TopBarActionsProfilePage
import com.example.cookpedia.ui.recipes.ui.RecipesScreen
import com.example.cookpedia.ui.recipes.ui.TopBarActionsRecipesPage
import com.example.cookpedia.ui.theme.UrbanistFont
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Compass
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Pager
import compose.icons.fontawesomeicons.solid.User


@Composable
fun CustomItemBottomBar(title:String, icon: ImageVector, selected:Boolean, onClick:()->Unit){
    Column(
        modifier = Modifier
            .clickable(
                onClick = onClick
            )
            .width(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.height(24.dp),
            imageVector = icon,
            tint = if (selected) Color(0xffF6484A) else Color.Gray,
            contentDescription = title,
        )
        Text(
            text = title,
            style = TextStyle(
                fontFamily = UrbanistFont,
                fontWeight = FontWeight.W600,
                fontSize = 11.sp,
                color = if (selected) Color(0xffF6484A) else Color.Gray
            )
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PrincipalScreen(navController: NavController, viewModel: PrincipalViewModel = hiltViewModel()){

    val selectedPage by viewModel.selectedPage.observeAsState()

    Scaffold(
        topBar = {
            selectedPage?.let {
                CustomTopBar(
                    it.title
                ) {
                    SelectedActionsScreen(navController = navController, selectedPage!!)
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
                elevation = 0.dp
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        ){

                    CustomItemBottomBar(
                        selected = selectedPage==AppScreens.HomeScreen,
                        icon = FontAwesomeIcons.Solid.Home,
                        title = "Home"
                    ) {
                        viewModel.selectedPage.value = AppScreens.HomeScreen
                    }
                    CustomItemBottomBar(
                        selected = selectedPage==AppScreens.DiscoverScreen,
                        icon = FontAwesomeIcons.Solid.Compass,
                        title = "Discover"
                    ) {
                        viewModel.selectedPage.value = AppScreens.DiscoverScreen
                    }
                    CustomItemBottomBar(
                        selected = selectedPage==AppScreens.RecipesScreen,
                        icon = FontAwesomeIcons.Solid.Pager,
                        title = "My Recipes"
                    ) {
                        viewModel.selectedPage.value = AppScreens.RecipesScreen
                    }
                    CustomItemBottomBar(
                        selected = selectedPage==AppScreens.ProfileScreen,
                        icon = FontAwesomeIcons.Solid.User,
                        title = "Profile"
                    ) {
                        viewModel.selectedPage.value = AppScreens.ProfileScreen
                    }
                }
            }
        }
    ) {
        selectedPage?.let { it1 ->
            SelectedScreen(
                pageSelected = it1,
                navController = navController
            )
        }
    }


}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SelectedActionsScreen(navController: NavController, pageSelected:AppScreens) {
    AnimatedContent(
        targetState = pageSelected,
        transitionSpec = {
            slideIntoContainer(
                animationSpec = tween(300, easing = LinearEasing),
                towards = Up
            ).with(
                slideOutOfContainer(
                    animationSpec = tween(300, easing = LinearEasing),
                    towards = Down
                )
            )
        }
    ) {
        when(pageSelected){
            AppScreens.HomeScreen -> TopBarActionsHomeScreen(navController = navController)
            AppScreens.DiscoverScreen -> TopBarActionsDiscoverScreen(navController = navController)
            AppScreens.RecipesScreen -> TopBarActionsRecipesPage(navController = navController)
            AppScreens.ProfileScreen -> TopBarActionsProfilePage(navController = navController)
            else -> {
                Text(text = "No hay")
            }
        }
    }
}


@Composable
fun SelectedScreen(pageSelected:AppScreens, navController: NavController){
    when(pageSelected){
        AppScreens.HomeScreen -> HomeScreen(navController = navController)
        AppScreens.DiscoverScreen -> DiscoverScreen(navController = navController)
        AppScreens.RecipesScreen -> RecipesScreen(navController = navController)
        AppScreens.ProfileScreen -> ProfileScreen(navController = navController)
        else -> {
            Text(text = "No hay")
        }
    }
}