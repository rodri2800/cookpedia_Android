package com.example.cookpedia.ui.discover.ui

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
import com.example.cookpedia.navigation.AppScreens

@Composable
fun TopBarActionsDiscoverScreen(navController: NavController?){
    Row {
        Icon(
            painter = painterResource(id = R.drawable.detail),
            contentDescription = "Details",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier.clickable {
                navController?.navigate(route = AppScreens.NotificationsScreen.route)
            }
                .width(24.dp),
        )

    }
}