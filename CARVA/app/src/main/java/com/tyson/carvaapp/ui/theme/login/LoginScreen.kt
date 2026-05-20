package com.tyson.carvaapp.ui.theme.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    onLogin: (String, String) -> Unit,
    onGoRegister: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {

        Text("Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(name, { name = it }, label = { Text("Name") })
        OutlinedTextField(password, { password = it }, label = { Text("Password") })

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                onLogin(name, password)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        TextButton(onClick = onGoRegister) {
            Text("Create Account")
        }
    }
}