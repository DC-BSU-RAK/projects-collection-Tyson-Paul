package com.tyson.carvaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.tyson.carvaapp.data.datastore.UserPreferences
import com.tyson.carvaapp.ui.theme.CARVATheme
import com.tyson.carvaapp.ui.theme.root.AppRoot
import com.tyson.carvaapp.ui.theme.splash.SplashScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            val prefs = remember {
                UserPreferences(this)
            }

            var showSplash by remember {
                mutableStateOf(true)
            }

            LaunchedEffect(Unit) {

                delay(2500)

                showSplash = false
            }

            CARVATheme {

                if (showSplash) {

                    SplashScreen {}

                } else {

                    AppRoot(prefs)
                }
            }
        }
    }
}