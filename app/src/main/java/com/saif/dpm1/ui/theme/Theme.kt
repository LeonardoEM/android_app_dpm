package com.saif.dpm1.ui.theme

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

// Tema claro - con colores morado, rojo y azul
private val LightColorScheme = lightColorScheme(
    primary = PrimaryPurple,           // Color principal morado
    onPrimary = Color.White,            // Texto blanco sobre morado
    primaryContainer = PurpleLight,     // Morado claro para contenedores
    onPrimaryContainer = PurpleDark,    // Texto morado oscuro sobre contenedor claro

    secondary = PrimaryRed,             // Rojo como secundario
    onSecondary = Color.White,          // Texto blanco sobre rojo
    secondaryContainer = RedLight,      // Rojo claro para contenedores
    onSecondaryContainer = RedDark,     // Texto rojo oscuro sobre contenedor claro

    tertiary = PrimaryBlue,             // Azul como terciario
    onTertiary = Color.White,           // Texto blanco sobre azul
    tertiaryContainer = BlueLight,      // Azul claro para contenedores
    onTertiaryContainer = BlueDark,     // Texto azul oscuro sobre contenedor claro

    background = Background,            // Fondo general (#F8F9FA)
    onBackground = OnBackground,        // Texto sobre fondo (#1A1A1A)

    surface = Surface,                   // Superficies blancas
    onSurface = OnSurface,               // Texto sobre superficies (#1A1A1A)
    surfaceVariant = SurfaceVariant,     // Fondo con toque morado

    error = Error,                       // Rojo para errores
    onError = Color.White,                // Texto blanco sobre error
    errorContainer = ErrorLight,          // Fondo rojo claro para errores
    onErrorContainer = RedDark            // Texto rojo oscuro sobre fondo error
)

// Tema oscuro - version adaptada
private val DarkColorScheme = darkColorScheme(
    primary = PurpleMedium,              // Morado mas claro en oscuro
    onPrimary = Color.Black,              // Texto negro sobre morado claro
    primaryContainer = PurpleDark,        // Morado oscuro para contenedores
    onPrimaryContainer = PurpleLight,     // Texto morado claro sobre contenedor oscuro

    secondary = RedMedium,                // Rojo medio en oscuro
    onSecondary = Color.Black,            // Texto negro sobre rojo
    secondaryContainer = RedDark,         // Rojo oscuro para contenedores
    onSecondaryContainer = RedLight,      // Texto rojo claro sobre contenedor oscuro

    tertiary = BlueMedium,                // Azul medio en oscuro
    onTertiary = Color.Black,             // Texto negro sobre azul
    tertiaryContainer = BlueDark,         // Azul oscuro para contenedores
    onTertiaryContainer = BlueLight,      // Texto azul claro sobre contenedor oscuro

    background = Color(0xFF121212),       // Fondo oscuro estandar
    onBackground = Color(0xFFE0E0E0),     // Texto claro sobre fondo oscuro

    surface = Color(0xFF1E1E1E),          // Superficies oscuras
    onSurface = Color(0xFFE0E0E0),        // Texto claro sobre superficies
    surfaceVariant = Color(0xFF2A2A2A),   // Variante oscura

    error = Color(0xFFCF6679),            // Rojo suave para oscuro
    onError = Color.Black,                 // Texto negro sobre error
    errorContainer = Color(0xFF8B0000),    // Rojo oscuro para contenedor error
    onErrorContainer = Color(0xFFE0E0E0)  // Texto claro sobre contenedor error
)

@Composable
fun Dpm1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,        // false para usar nuestros colores
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
        content = content
    )
}