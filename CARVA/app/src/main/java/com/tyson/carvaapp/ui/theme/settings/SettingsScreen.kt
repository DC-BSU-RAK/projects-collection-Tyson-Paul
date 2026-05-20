package com.tyson.carvaapp.ui.theme.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tyson.carvaapp.SettingsViewModel

@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {

    val vm: SettingsViewModel = viewModel()

    val darkMode by vm.darkMode.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Dark Mode")

            Spacer(modifier = Modifier.weight(1f))

            Switch(
                checked = darkMode,
                onCheckedChange = {
                    vm.toggleDarkMode(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}