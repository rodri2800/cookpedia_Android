package com.example.cookpedia.ui.notifications.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.cookpedia.R
import com.example.cookpedia.ui.components.CustomCardGeneralNotification

@Composable
private fun BodyContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomCardGeneralNotification(
            userImage = painterResource(id = R.drawable.perfil),
            userName = "Jane Cooper",
            day = 0,
            time = "09:24 AM",
            mealImage = painterResource(id = R.drawable.ensalada),
            action = "has published a new recipe!",
            read = true
        )
        CustomCardGeneralNotification(
            userImage = painterResource(id = R.drawable.perfil),
            userName = "Jane Cooper",
            day = 1,
            time = "11:24 AM",
            mealImage = painterResource(id = R.drawable.lasanademo),
            action = "has published a new recipe!"
        )
    }

}

@Composable
fun GeneralNotificationsScreen() {
    BodyContent()
}