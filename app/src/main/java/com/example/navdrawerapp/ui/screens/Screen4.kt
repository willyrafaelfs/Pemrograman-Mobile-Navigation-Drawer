package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen4.kt
 * ===============
 * Halaman Screen 4 (Baru).
 */

@Composable
fun Screen4(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Screen 4",
        description = "Ini adalah Screen 4 yang baru saja ditambahkan ke dalam sistem navigasi drawer.",
        onBackClick = onBackClick
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen4Preview() {
    NavDrawerAppTheme {
        Screen4(onBackClick = {})
    }
}
