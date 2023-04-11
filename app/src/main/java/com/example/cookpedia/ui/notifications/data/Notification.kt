package com.example.cookpedia.ui.notifications.data


import androidx.compose.ui.graphics.Color
import com.example.cookpedia.R

sealed class Notification(val icon: Int, val color:Color){
    object BookmarkNotification: Notification(
        icon = R.drawable.bookmark_black_24dp,
        color = Color(251, 160, 29)
    )

    object UserNotification: Notification(
        icon = R.drawable.user,
        color = Color(38,213,152)
    )

    object SecurityNotification: Notification(
        icon = R.drawable.shield,
        color = Color(59,123,254)
    )

    object InformationNotification: Notification(
        icon = R.drawable.information,
        color = Color(111, 81, 255)
    )

    object StorageNotification: Notification(
        icon = R.drawable.folder,
        color = Color(245,82,84)
    )

}
