package com.example.navdrawerapp.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * File Theme.kt
 * =============
 * Konfigurasi tema Material3 untuk aplikasi.
 * Menggunakan warna-warna yang sudah didefinisikan di Color.kt.
 */

// Skema warna Light (terang) menggunakan warna dari Color.kt
private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = TextOnPrimary,
    primaryContainer = PrimaryLight,
    secondary = Secondary,
    onSecondary = TextOnPrimary,
    background = BackgroundMain,
    onBackground = TextPrimary,
    surface = BackgroundScreen,
    onSurface = TextPrimary,
    surfaceVariant = ContentCardBackground,
    onSurfaceVariant = TextSecondary
)

@Composable
fun NavDrawerAppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    // Mengatur warna status bar agar sesuai dengan tema
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = PrimaryDark.toArgb()
            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
