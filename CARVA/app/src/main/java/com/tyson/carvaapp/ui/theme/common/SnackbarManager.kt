package com.tyson.carvaapp.ui.theme.common

import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun rememberSnackbar(): SnackbarHostState {
    return remember { SnackbarHostState() }
}