package com.example.navdrawerapp.ui.navigation

/**
 * File NavigationRoutes.kt
 * ========================
 * Mendefinisikan semua route navigasi yang digunakan dalam aplikasi.
 *
 * Bayangkan route seperti "alamat" setiap halaman.
 * Ketika kita ingin berpindah halaman, kita cukup menyebutkan
 * alamat (route) dari halaman tujuan.
 */

// Sealed class memastikan hanya route yang didefinisikan di sini yang bisa digunakan
sealed class Screen(val route: String, val title: String) {

    // Route untuk halaman utama (Home dengan Drawer)
    object Home : Screen(
        route = "home",
        title = "Menu Utama"
    )

    // Route untuk Screen 1
    object Screen1 : Screen(
        route = "screen_1",
        title = "Screen 1"
    )

    // Route untuk Screen 2
    object Screen2 : Screen(
        route = "screen_2",
        title = "Screen 2"
    )

    // Route untuk Screen 3
    object Screen3 : Screen(
        route = "screen_3",
        title = "Screen 3"
    )

    // Route untuk Screen 4
    object Screen4 : Screen(
        route = "screen_4",
        title = "Screen 4"
    )

    // Route untuk Screen 5
    object Screen5 : Screen(
        route = "screen_5",
        title = "Screen 5"
    )
}
