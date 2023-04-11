package com.example.cookpedia.ui.notifications.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cookpedia.ui.components.CustomCardSystemNotification
import com.example.cookpedia.ui.notifications.data.Notification

@Composable
private fun BodyContent() {
    val stateScroll = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(stateScroll)
    ) {
        CustomCardSystemNotification(
            notificationType = Notification.UserNotification,
            title = "Security Updates!",
            information = "Now Cookpedia has a Two-Factor Authencatication. Try it now to make your account more.",
        )
        CustomCardSystemNotification(
            notificationType = Notification.SecurityNotification,
            title = "Security Updates!",
            information = "Now Cookpedia has a Two-Factor Authencatication. Try it now to make your account more.",
            read = true
        )
        CustomCardSystemNotification(
            notificationType = Notification.BookmarkNotification,
            title = "Security Updates!",
            information = "Now Cookpedia has a Two-Factor Authencatication. Try it now to make your account more.",
            read = true
        )
        CustomCardSystemNotification(
            notificationType = Notification.StorageNotification,
            title = "Security Updates!",
            information = "Now Cookpedia has a Two-Factor Authencatication. Try it now to make your account more.",
            read = true
        )
    }
}

@Composable
fun SystemNotificationsScreen() {
    BodyContent()
}