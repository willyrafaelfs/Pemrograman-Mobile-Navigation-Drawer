package com.example.navdrawerapp.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * File Color.kt
 * ============
 * Semua warna didefinisikan di sini menggunakan nilai hexadecimal
 * yang sama dengan file color.xml agar konsisten.
 *
 * Catatan: Di Jetpack Compose, kita menggunakan Color() dari Compose,
 * sedangkan color.xml digunakan untuk komponen XML tradisional.
 */

// === Warna Utama (Primary) ===
val Primary = Color(0xFF2E7D32)          // Hijau utama
val PrimaryDark = Color(0xFF1B5E20)      // Hijau gelap
val PrimaryLight = Color(0xFF4CAF50)     // Hijau terang

// === Warna Sekunder (Secondary) ===
val Secondary = Color(0xFFFF6F00)        // Oranye
val SecondaryDark = Color(0xFFE65100)    // Oranye gelap

// === Warna Background ===
val BackgroundMain = Color(0xFFF5F5F5)   // Abu-abu sangat terang
val BackgroundDrawer = Color(0xFFFFFFFF) // Putih
val BackgroundScreen = Color(0xFFFAFAFA) // Putih keabu-abuan

// === Warna Teks ===
val TextPrimary = Color(0xFF212121)      // Hitam gelap
val TextSecondary = Color(0xFF757575)    // Abu-abu
val TextOnPrimary = Color(0xFFFFFFFF)    // Putih (teks di atas primary)

// === Warna Top App Bar ===
val TopBarBackground = Color(0xFF2E7D32) // Sama dengan Primary
val TopBarContent = Color(0xFFFFFFFF)    // Putih

// === Warna Drawer ===
val DrawerHeaderBackground = Color(0xFF1B5E20)    // Hijau gelap
val DrawerHeaderText = Color(0xFFFFFFFF)           // Putih
val DrawerItemSelected = Color(0xFFE8F5E9)         // Hijau sangat terang
val DrawerItemSelectedText = Color(0xFF2E7D32)     // Hijau utama
val DrawerItemUnselectedText = Color(0xFF424242)   // Abu-abu gelap
val DrawerDivider = Color(0xFFE0E0E0)              // Abu-abu terang

// === Warna Konten ===
val ContentText = Color(0xFF333333)                // Hitam lembut
val ContentCardBackground = Color(0xFFFFFFFF)      // Putih
val ContentCardBorder = Color(0xFFE0E0E0)          // Abu-abu terang

// === Warna Icon ===
val IconActive = Color(0xFF2E7D32)       // Hijau (aktif)
val IconInactive = Color(0xFF9E9E9E)     // Abu-abu (tidak aktif)
