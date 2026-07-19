package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen2.kt
 * ===============
 * Halaman Screen 2.
 *
 * Sama seperti Screen 1, menggunakan ScreenContent generik
 * dengan judul dan konten yang berbeda.
 */

@Composable
fun Screen2(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Screen 2",
        description = "Halaman ini adalah Screen 2. Anda dapat melihat informasi detail di sini dan berinteraksi dengan tombol di bawah.",
        onBackClick = onBackClick
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen2Preview() {
    NavDrawerAppTheme {
        Screen2(onBackClick = {})
    }
}
