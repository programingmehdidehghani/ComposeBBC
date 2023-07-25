package com.example.samplecompose.navigation

import com.example.samplecompose.R
import com.example.samplecompose.util.Constants

sealed class BottomNavItem(
    val title: String,
    val image: Int,
    val route: String
){
    object Agents: BottomNavItem(
        title = Constants.CATEGORY_AGENTS,
        image = R.drawable.ic_agents,
        route = Screen.Agents.route
    )
    object Maps: BottomNavItem(
        title = Constants.CATEGORY_MAPS,
        image = R.drawable.ic_maps,
        route = Screen.Maps.route
    )
    object Weapons: BottomNavItem(
        title = Constants.CATEGORY_WEAPONS,
        image = R.drawable.ic_weapons,
        route = Screen.Weapons.route
    )
    object Tiers: BottomNavItem(
        title = Constants.CATEGORY_COMPETITIVE_TIERS,
        image = R.drawable.ic_tiers,
        route = Screen.CompetitiveTiers.route
    )
}
