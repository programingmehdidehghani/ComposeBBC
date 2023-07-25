package com.example.samplecompose.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ){
        composable(route = BottomNavItem.Home.route){


        }
        composable(route = BottomNavItem.Profile.route){

        }
        composable(route = BottomNavItem.Setting.route){

        }
    }

}