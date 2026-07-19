package com.example.navdrawerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navdrawerapp.ui.screens.HomeScreen
import com.example.navdrawerapp.ui.screens.Screen1
import com.example.navdrawerapp.ui.screens.Screen2
import com.example.navdrawerapp.ui.screens.Screen3
import com.example.navdrawerapp.ui.screens.Screen4
import com.example.navdrawerapp.ui.screens.Screen5

/**
 * File NavGraph.kt
 * ================
 * Navigation Graph = peta navigasi seluruh halaman dalam aplikasi.
 *
 * Cara kerja:
 * 1. NavHost menampung semua halaman (composable) yang bisa ditampilkan
 * 2. Setiap halaman didaftarkan dengan route (alamat) unik
 * 3. Untuk berpindah halaman, cukup panggil navController.navigate(route)
 *
 * Analogi: NavGraph seperti peta jalan kota.
 * Setiap halaman = destinasi (toko, rumah, kantor).
 * Route = alamat jalan menuju destinasi.
 * NavController = GPS yang mengarahkan kita.
 *
 * Alur navigasi aplikasi ini:
 * Home (Drawer) ──┬──> Screen 1 ──> (Back) ──> Home
 *                 ├──> Screen 2 ──> (Back) ──> Home
 *                 └──> Screen 3 ──> (Back) ──> Home
 */

@Composable
fun NavGraph(
    navController: NavHostController          // Controller untuk mengatur navigasi
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route  // Halaman pertama yang ditampilkan = Home
    ) {
        // === HALAMAN HOME (dengan Navigation Drawer) ===
        composable(route = Screen.Home.route) {
            HomeScreen(
                onNavigateToScreen = { screen ->
                    // Navigasi ke screen yang dipilih dari drawer
                    navController.navigate(screen.route)
                }
            )
        }

        // === HALAMAN SCREEN 1 ===
        composable(route = Screen.Screen1.route) {
            Screen1(
                onBackClick = {
                    // Kembali ke halaman sebelumnya (Home)
                    navController.popBackStack()
                }
            )
        }

        // === HALAMAN SCREEN 2 ===
        composable(route = Screen.Screen2.route) {
            Screen2(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // === HALAMAN SCREEN 3 ===
        composable(route = Screen.Screen3.route) {
            Screen3(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // === HALAMAN SCREEN 4 ===
        composable(route = Screen.Screen4.route) {
            Screen4(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // === HALAMAN SCREEN 5 ===
        composable(route = Screen.Screen5.route) {
            Screen5(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
