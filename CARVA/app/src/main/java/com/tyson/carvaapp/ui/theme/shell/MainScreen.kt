package com.tyson.carvaapp.ui.shell

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.tyson.carvaapp.data.datastore.UserPreferences
import com.tyson.carvaapp.ui.theme.home.HomeScreen
import com.tyson.carvaapp.ui.theme.history.HistoryScreen
import com.tyson.carvaapp.ui.theme.profile.ProfileScreen
import com.tyson.carvaapp.ui.theme.service.AddServiceScreen
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    prefs: UserPreferences
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {

                NavigationBarItem(
                    selected = currentRoute == "home",
                    onClick = {
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = false }
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("Home") }
                )

                NavigationBarItem(
                    selected = currentRoute == "history",
                    onClick = {
                        navController.navigate("history") {
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Default.List, null) },
                    label = { Text("History") }
                )

                NavigationBarItem(
                    selected = currentRoute == "profile",
                    onClick = {
                        navController.navigate("profile") {
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("Profile") }
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") {
                HomeScreen(
                    onAddService = {
                        navController.navigate("add_service")
                    }
                )
            }

            composable("history") {
                HistoryScreen()
            }

            composable("profile") {
                ProfileScreen(
                    onLogout = {
                        scope.launch {
                            prefs.clearUser() // ✅ FIXED (suspend call inside coroutine)

                            navController.navigate("home") {
                                popUpTo(0) // clears back stack → real logout effect
                            }
                        }
                    }
                )
            }

            composable("add_service") {
                AddServiceScreen(
                    onDone = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}