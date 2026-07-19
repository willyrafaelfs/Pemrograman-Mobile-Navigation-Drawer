package com.example.navdrawerapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navdrawerapp.ui.theme.*

/**
 * File ScreenContent.kt
 * =====================
 * Composable generik yang dipakai oleh Screen 1, Screen 2, dan Screen 3.
 *
 * Setiap screen memiliki pola yang sama:
 * - TopAppBar dengan tombol back arrow dan judul
 * - Area konten di tengah layar berisi teks
 *
 * Dengan membuat komponen generik ini, kita menghindari duplikasi kode.
 * Prinsip DRY (Don't Repeat Yourself)!
 *
 * Analogi: Seperti template surat. Isi dan judul berubah,
 * tapi formatnya tetap sama.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent(
    title: String,               // Judul yang ditampilkan di TopAppBar dan konten
    description: String,         // Deskripsi yang ditampilkan di area isi
    onBackClick: () -> Unit      // Callback ketika tombol back arrow diklik
) {
    // Scaffold menyediakan struktur dasar: TopBar + Content area
    Scaffold(
        // === TOP APP BAR ===
        topBar = {
            TopAppBar(
                // Judul halaman
                title = {
                    Text(
                        text = title,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                // Tombol navigasi back
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali"
                        )
                    }
                },
                // Warna TopAppBar
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = TopBarBackground,
                    titleContentColor = TopBarContent,
                    navigationIconContentColor = TopBarContent
                )
            )
        },
        containerColor = BackgroundScreen
    ) { paddingValues ->
        // === AREA KONTEN ===
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 1. Judul (Text bold)
            Text(
                text = title,
                color = TextPrimary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 2. Deskripsi (Text normal)
            Text(
                text = description,
                color = ContentText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // 3. Button
            Button(
                onClick = { /* Aksi tombol */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                )
            ) {
                Text(text = "Klik Saya")
            }
        }
    }
}
