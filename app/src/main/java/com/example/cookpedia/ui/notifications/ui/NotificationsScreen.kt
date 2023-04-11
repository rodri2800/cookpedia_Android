package com.example.cookpedia.ui.notifications.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.example.cookpedia.R
import com.example.cookpedia.navigation.AppScreens
import com.example.cookpedia.ui.components.CustomTopBarWithButtonBack
import com.example.cookpedia.ui.theme.PrimaryRedColor


@Composable
private fun BodyContent() {

    var pageSelected:Int by remember {
        mutableStateOf(0)
    }

    val tabs = listOf("General", "System")

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(
            modifier = Modifier.padding(horizontal = 20.dp),
            selectedTabIndex = pageSelected,
            backgroundColor = Color.Transparent,
            contentColor = PrimaryRedColor
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = pageSelected == index,
                    onClick = { pageSelected = index },
                    selectedContentColor = PrimaryRedColor,
                    unselectedContentColor = Color.Gray
                )
            }
        }

        when(pageSelected){
            0-> GeneralNotificationsScreen()
            1-> SystemNotificationsScreen()
        }
    }

    

}

@Composable
private fun Actions(navController: NavController?){
    Row {
        Icon(
            painter = painterResource(id = R.drawable.setting),
            contentDescription = "Settings",
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
fun NotifitationsScreen(navController: NavController?){
    Scaffold(
        topBar = {
            CustomTopBarWithButtonBack(title = AppScreens.NotificationsScreen.title, navController = navController) {
                Actions(navController = navController)
            }
        }
    ) {
        BodyContent()
    }
}