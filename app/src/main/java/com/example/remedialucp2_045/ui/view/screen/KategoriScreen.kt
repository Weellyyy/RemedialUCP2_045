package com.example.remedialucp2_045.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.remedialucp2_045.room.Kategori
import com.example.remedialucp2_045.ui.viewmodel.PerpustakaanViewModel
import com.example.remedialucp2_045.ui.viewmodel.provider.PenyediaViewModel
import com.example.remedialucp2_045.view.route.DestinasiBuku

@Composable
fun KategoriScreen(
    navController: NavController,
    viewModel: PerpustakaanViewModel = viewModel(
        factory = PenyediaViewModel.Factory
    )
) {
    val kategoriList by viewModel.kategoriUiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Kategori", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(kategoriList) { kategori ->
                Text(text = kategori.nama)
                Divider()
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            viewModel.insertKategori(
                Kategori(
                    nama = "Kategori Baru",
                    parentId = null?: 0
                )
            )
        }) {
            Text("Tambah Kategori")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            navController.navigate(DestinasiBuku.route)
        }) {
            Text("Ke Buku")
        }
    }
}
