package com.example.cookpedia.ui.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cookpedia.R
import com.example.cookpedia.navigation.AppScreens

@Composable
fun TopBarActionsHomeScreen(navController: NavController?){
    Row {
        Icon(
            Icons.Outlined.Notifications,
            contentDescription = "Notificaciones",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier.clickable {
                navController?.navigate(route = AppScreens.NotificationsScreen.route)
            },
        )
        Spacer(modifier = Modifier.width(15.dp))
        Icon(
            painter = painterResource(id = R.drawable.bookmark_border_black_24dp),
            contentDescription = "Bookmark",
            tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
            modifier = Modifier.clickable {
                navController?.navigate(route = AppScreens.BookmarkScreen.route)
            }
        )
    }
}