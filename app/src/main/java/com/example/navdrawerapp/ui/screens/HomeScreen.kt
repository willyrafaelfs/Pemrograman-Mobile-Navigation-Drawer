package com.example.navdrawerapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navdrawerapp.ui.components.DrawerContent
import com.example.navdrawerapp.ui.navigation.Screen
import com.example.navdrawerapp.ui.theme.*
import kotlinx.coroutines.launch

/**
 * File HomeScreen.kt
 * ==================
 * Halaman utama (Home) yang mengandung Navigation Drawer.
 *
 * Cara kerja Navigation Drawer:
 * 1. User menekan ikon hamburger (≡) di TopAppBar
 * 2. Panel drawer muncul dari kiri (slide)
 * 3. User memilih salah satu menu (Screen 1 / 2 / 3)
 * 4. Drawer tertutup, dan halaman berpindah ke screen yang dipilih
 *
 * Analogi: Seperti buku menu di restoran.
 * Kamu buka menu → pilih makanan → menu ditutup → makanan datang.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToScreen: (Screen) -> Unit     // Callback navigasi ke screen tujuan
) {
    // State untuk mengontrol buka/tutup drawer
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    // CoroutineScope dibutuhkan karena membuka/menutup drawer adalah operasi suspend
    val scope = rememberCoroutineScope()

    // ModalNavigationDrawer = komponen drawer yang slide dari kiri
    ModalNavigationDrawer(
        // State drawer (buka/tutup)
        drawerState = drawerState,

        // Isi dari panel drawer (menu-menu)
        drawerContent = {
            DrawerContent(
                currentRoute = null,     // Di Home, tidak ada menu yang aktif
                onMenuClick = { screen ->
                    // Ketika menu diklik:
                    scope.launch {
                        drawerState.close()          // 1. Tutup drawer dulu
                    }
                    onNavigateToScreen(screen)       // 2. Navigasi ke screen tujuan
                }
            )
        }
    ) {
        // === KONTEN UTAMA (di belakang drawer) ===
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Menu Utama",
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    // Tombol hamburger (≡) untuk membuka drawer
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()   // Buka drawer saat ikon diklik
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Buka Menu"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = TopBarBackground,
                        titleContentColor = TopBarContent,
                        navigationIconContentColor = TopBarContent
                    )
                )
            },
            containerColor = BackgroundScreen
        ) { paddingValues ->
            // Area konten Home
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Selamat Datang!",
                        color = TextPrimary,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Geser dari kiri atau tekan ikon menu\nuntuk membuka Navigation Drawer",
                        color = TextSecondary,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 32.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    NavDrawerAppTheme {
        HomeScreen(onNavigateToScreen = {})
    }
}
