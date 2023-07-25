package com.example.samplecompose.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        graph = BottomBarScreen
    )

}