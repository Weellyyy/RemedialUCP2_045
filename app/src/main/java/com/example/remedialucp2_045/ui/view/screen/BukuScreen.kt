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
import com.example.remedialucp2_045.room.Buku
import com.example.remedialucp2_045.ui.viewmodel.BukuViewModel
import com.example.remedialucp2_045.ui.viewmodel.provider.PenyediaViewModel

@Composable
fun BukuScreen(
    navController: NavController,
    viewModel: BukuViewModel = viewModel(
        factory = PenyediaViewModel.Factory
    )
) {
    val bukuList by viewModel.bukuList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Buku", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(bukuList) { buku ->
                Text(text = buku.judul)
                Divider()
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            viewModel.insertBuku(
                Buku(
                    judul = "Buku Baru",
                    KategoriId = null
                )
            )
        }) {
            Text("Tambah Buku")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Kembali")
        }
    }
}
