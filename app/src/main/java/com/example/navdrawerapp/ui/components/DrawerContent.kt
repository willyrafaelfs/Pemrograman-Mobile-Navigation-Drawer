package com.example.navdrawerapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navdrawerapp.ui.navigation.Screen
import com.example.navdrawerapp.ui.theme.*

/**
 * File DrawerContent.kt
 * =====================
 * Komponen ini menampilkan isi dari Navigation Drawer.
 *
 * Navigation Drawer = panel samping yang bisa digeser dari kiri.
 * Berisi daftar menu yang bisa diklik untuk berpindah halaman.
 *
 * Analogi: Seperti daftar isi buku. Klik salah satu bab,
 * maka halaman akan langsung berpindah ke bab tersebut.
 */

// Data class untuk menyimpan informasi setiap item menu drawer
data class DrawerMenuItem(
    val screen: Screen,                          // Route tujuan
    val icon: @Composable () -> Unit,            // Ikon menu
    val label: String                            // Teks label menu
)

@Composable
fun DrawerContent(
    currentRoute: String?,                       // Route halaman yang sedang aktif
    onMenuClick: (Screen) -> Unit,               // Callback ketika menu diklik
    modifier: Modifier = Modifier
) {
    // Daftar semua menu yang ditampilkan di drawer
    val menuItems = listOf(
        DrawerMenuItem(
            screen = Screen.Screen1,
            icon = { Icon(Icons.Default.Home, contentDescription = "Screen 1") },
            label = "Screen 1"
        ),
        DrawerMenuItem(
            screen = Screen.Screen2,
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Screen 2") },
            label = "Screen 2"
        ),
        DrawerMenuItem(
            screen = Screen.Screen3,
            icon = { Icon(Icons.Default.Settings, contentDescription = "Screen 3") },
            label = "Screen 3"
        ),
        DrawerMenuItem(
            screen = Screen.Screen4,
            icon = { Icon(Icons.Default.Person, contentDescription = "Screen 4") },
            label = "Screen 4"
        ),
        DrawerMenuItem(
            screen = Screen.Screen5,
            icon = { Icon(Icons.Default.Info, contentDescription = "Screen 5") },
            label = "Screen 5"
        )
    )

    // Layout utama drawer
    ModalDrawerSheet(
        modifier = modifier,
        drawerContainerColor = BackgroundDrawer      // Warna background drawer (putih)
    ) {
        // === HEADER DRAWER ===
        // Area atas drawer dengan background hijau gelap
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(DrawerHeaderBackground),
            contentAlignment = Alignment.BottomStart
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // e) Tambahkan foto/avatar di header drawer
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "User Avatar",
                    modifier = Modifier.size(80.dp),
                    tint = DrawerHeaderText
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Text(
                    text = "Navigation Drawer",
                    color = DrawerHeaderText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "user@example.com",
                    color = DrawerHeaderText.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // === DAFTAR MENU ===
        // Menampilkan setiap menu item menggunakan loop
        menuItems.forEach { menuItem ->
            // Cek apakah menu ini sedang aktif (dipilih)
            val isSelected = currentRoute == menuItem.screen.route

            NavigationDrawerItem(
                icon = menuItem.icon,
                label = {
                    Text(
                        text = menuItem.label,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                selected = isSelected,
                onClick = {
                    // Panggil callback ketika menu diklik
                    onMenuClick(menuItem.screen)
                },
                // f) Buat agar item drawer yang sedang aktif (selected) menampilkan badge
                badge = {
                    if (isSelected) {
                        Badge {
                            Text("Aktif")
                        }
                    }
                },
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = DrawerItemSelected,
                    selectedTextColor = DrawerItemSelectedText,
                    selectedIconColor = IconActive,
                    unselectedTextColor = DrawerItemUnselectedText,
                    unselectedIconColor = IconInactive,
                    selectedBadgeColor = Primary
                ),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Garis pembatas (divider) di bawah menu
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = DrawerDivider                     // Warna abu-abu terang dari color.xml
        )
    }
}
