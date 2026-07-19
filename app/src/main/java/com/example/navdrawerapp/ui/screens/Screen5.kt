package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen5.kt
 * ===============
 * Halaman Screen 5 (Baru).
 */

@Composable
fun Screen5(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Screen 5",
        description = "Halaman terakhir, Screen 5, lengkap dengan judul bold, deskripsi normal, dan sebuah tombol.",
        onBackClick = onBackClick
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen5Preview() {
    NavDrawerAppTheme {
        Screen5(onBackClick = {})
    }
}
