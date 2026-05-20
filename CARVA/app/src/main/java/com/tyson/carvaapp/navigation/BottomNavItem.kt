package com.tyson.carvaapp.navigation

sealed class BottomNavItem(
    val route: String,
    val title: String
) {
    object Home : BottomNavItem("home", "Home")
    object History : BottomNavItem("history", "History")
    object Profile : BottomNavItem("profile", "Profile")
}