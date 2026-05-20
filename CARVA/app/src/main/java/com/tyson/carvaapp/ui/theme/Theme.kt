package com.tyson.carvaapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// =======================
// LIGHT COLORS
// =======================

private val LightColors = lightColorScheme(

    primary = Color(0xFF0F172A),          // Dark navy
    secondary = Color(0xFF2563EB),        // Blue
    tertiary = Color(0xFF06B6D4),         // Cyan

    background = Color(0xFFF8FAFC),
    surface = Color(0xFFFFFFFF),

    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFF0F172A),
    onSurface = Color(0xFF0F172A)
)

// =======================
// DARK COLORS
// =======================

private val DarkColors = darkColorScheme(

    primary = Color(0xFF60A5FA),
    secondary = Color(0xFF38BDF8),
    tertiary = Color(0xFF22D3EE),

    background = Color(0xFF020617),
    surface = Color(0xFF111827),

    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

// =======================
// THEME
// =======================

@Composable
fun CARVATheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors =
        if (darkTheme) DarkColors
        else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}