package com.example.samplecompose.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.samplecompose.presention.HomeScreen
import com.example.samplecompose.presention.ProfileScreen
import com.example.samplecompose.presention.SettingScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ){
        composable(route = BottomNavItem.Home.route){
            HomeScreen()
        }
        composable(route = BottomNavItem.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomNavItem.Setting.route){
            SettingScreen()
        }
    }

}