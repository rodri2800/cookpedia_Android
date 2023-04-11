package com.example.cookpedia.ui.recipes.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cookpedia.R

@Composable
fun TopBarActionsRecipesPage(navController: NavController?){
    Row {
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "Buscar",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier.clickable {

            }
                .width(24.dp),
        )
        Spacer(modifier = Modifier.width(15.dp))
        Icon(
            painter = painterResource(id = R.drawable.detail),
            contentDescription = "Details",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier
                .clickable {

                }
                .width(24.dp),
        )

    }
}
