package com.example.healthyfitness.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = LemonGreen,
    secondary = DarkGreen,
    tertiary = White,

//     Other default colors to override
    background = LightBlack,
    surface = DarkGreen,
    onPrimary = Black,
    onSecondary = White,
    onTertiary = LemonGreen,
)

private val LightColorScheme = lightColorScheme(
    primary = LemonGreen,
    secondary = DarkGreen,
    tertiary = White,

//     Other default colors to override
    background = LightBlack,
    surface = DarkGreen,
    onPrimary = Black,
    onSecondary = White,
    onTertiary = LemonGreen,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
)

@Composable
fun HealthyFitnessTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = fitnessShapes
    )
}