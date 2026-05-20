package com.tyson.carvaapp.ui.theme.carsetup

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CarSetupScreen(
    onSetupComplete: (String, String, String) -> Unit
) {

    var carName by remember { mutableStateOf("") }
    var plate by remember { mutableStateOf("") }
    var km by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {

        Text("Car Setup", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(carName, { carName = it }, label = { Text("Car Name") })
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(plate, { plate = it }, label = { Text("Plate") })
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(km, { km = it }, label = { Text("KM Driven") })

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                onSetupComplete(carName, plate, km)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Car")
        }
    }
}