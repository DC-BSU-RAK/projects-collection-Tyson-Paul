package com.tyson.carvaapp.ui.shell

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.tyson.carvaapp.navigation.Routes

@Composable
fun BottomNavBar(
    current: String,
    onChange: (String) -> Unit
) {
    NavigationBar {

        NavigationBarItem(
            selected = current == Routes.HOME,
            onClick = { onChange(Routes.HOME) },
            label = { Text("Home") },
            icon = { Text("🏠") }
        )

        NavigationBarItem(
            selected = current == Routes.HISTORY,
            onClick = { onChange(Routes.HISTORY) },
            label = { Text("History") },
            icon = { Text("📊") }
        )

        NavigationBarItem(
            selected = current == Routes.PROFILE,
            onClick = { onChange(Routes.PROFILE) },
            label = { Text("Profile") },
            icon = { Text("👤") }
        )
    }
}