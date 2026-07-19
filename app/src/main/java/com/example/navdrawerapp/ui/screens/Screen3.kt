package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen3.kt
 * ===============
 * Halaman Screen 3.
 *
 * Sama seperti Screen 1 dan 2, menggunakan ScreenContent generik
 * dengan judul dan konten yang berbeda.
 */

@Composable
fun Screen3(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Screen 3",
        description = "Selamat datang di Screen 3. Komponen di sini telah diperbarui untuk memberikan pengalaman pengguna yang lebih baik.",
        onBackClick = onBackClick
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen3Preview() {
    NavDrawerAppTheme {
        Screen3(onBackClick = {})
    }
}
