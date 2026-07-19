package com.example.navdrawerapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File Screen1.kt
 * ===============
 * Halaman Screen 1.
 *
 * Menggunakan ScreenContent (komponen generik) dengan parameter:
 * - title = "Screen 1" → ditampilkan di TopAppBar
 * - contentText = "Ini adalah area konten Screen 1" → ditampilkan di tengah layar
 * - onBackClick = callback untuk kembali ke drawer/home
 */

@Composable
fun Screen1(
    onBackClick: () -> Unit      // Fungsi yang dipanggil saat tombol back diklik
) {
    ScreenContent(
        title = "Screen 1",
        description = "Ini adalah deskripsi lengkap untuk Screen 1 yang sekarang menggunakan format Column dengan judul, teks normal, dan tombol.",
        onBackClick = onBackClick
    )
}

// Preview untuk melihat tampilan Screen 1 di Android Studio
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen1Preview() {
    NavDrawerAppTheme {
        Screen1(onBackClick = {})
    }
}
