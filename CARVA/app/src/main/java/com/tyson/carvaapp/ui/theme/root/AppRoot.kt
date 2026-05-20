package com.tyson.carvaapp.ui.theme.root

import androidx.compose.runtime.*
import com.tyson.carvaapp.data.datastore.UserPreferences
import com.tyson.carvaapp.ui.theme.login.LoginScreen
import com.tyson.carvaapp.ui.theme.register.RegisterScreen
import com.tyson.carvaapp.ui.shell.MainScreen
import kotlinx.coroutines.launch

@Composable
fun AppRoot(prefs: UserPreferences) {

    val scope = rememberCoroutineScope()

    val username by prefs.username.collectAsState(initial = "")

    var showRegister by remember { mutableStateOf(false) }

    val loggedIn = username.isNotEmpty()

    when {

        !loggedIn && !showRegister -> {
            LoginScreen(
                onLogin = { name, pass ->
                    scope.launch {
                        prefs.setUser(name, "", "")
                    }
                },
                onGoRegister = {
                    showRegister = true
                }
            )
        }

        !loggedIn && showRegister -> {
            RegisterScreen { name, phone, email, pass ->
                scope.launch {
                    prefs.setUser(name, email, phone)
                    showRegister = false
                }
            }
        }

        else -> {
            MainScreen(prefs = prefs)
        }
    }
}