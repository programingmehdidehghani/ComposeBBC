package com.example.samplecompose.bottomNavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController, paddingValues: PaddingValues){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {}
    ) {
        BottomNavGraph(navController = navController)

    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomNavItem.Home,
        BottomNavItem.Profile,
        BottomNavItem.Setting
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

}