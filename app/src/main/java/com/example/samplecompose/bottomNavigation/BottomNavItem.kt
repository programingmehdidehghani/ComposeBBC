package com.example.samplecompose.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.samplecompose.R
import com.example.samplecompose.util.Constants

sealed class BottomNavItem(
    val title: String,
    val image: ImageVector,
    val route: String
){
    object Home: BottomNavItem(
        title = "Home",
        image = Icons.Default.Home,
        route = "home"
    )
    object Profile: BottomNavItem(
        title = "profile",
        image = Icons.Default.Person,
        route = "profile"
    )
    object Setting: BottomNavItem(
        title = "setting",
        image = Icons.Default.Settings,
        route = "setting"
    )

}
