package com.example.samplecompose.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val image: ImageVector,
    val route: String
){
    object News: BottomNavItem(
        title = "News",
        image = Icons.Default.Home,
        route = "home"
    )
    object Favorite: BottomNavItem(
        title = "Favorite",
        image = Icons.Default.Settings,
        route = "setting"
    )

}
