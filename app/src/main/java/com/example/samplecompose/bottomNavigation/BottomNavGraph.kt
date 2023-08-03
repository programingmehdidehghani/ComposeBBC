package com.example.samplecompose.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.samplecompose.presention.favouriteScreen.FavoriteScreen
import com.example.samplecompose.presention.NewsScreen.NewsScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.News.route
    ){
        composable(route = BottomNavItem.News.route){
            NewsScreen()
        }
        composable(route = BottomNavItem.Favorite.route){
            FavoriteScreen()
        }
    }

}