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
import com.example.remedialucp2_045.ui.viewmodel.AuditLogViewModel
import com.example.remedialucp2_045.ui.viewmodel.provider.PenyediaViewModel

@Composable
fun AuditLogScreen(
    navController: NavController,
    viewModel: AuditLogViewModel = viewModel(
        factory = PenyediaViewModel.Factory
    )
) {
    val auditLogs by viewModel.auditLogList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Audit Log", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(auditLogs) { log ->
                Text(
                    text = "${log.action} - ${log.tableName}"
                )
                Text(
                    text = "Old: ${log.oldData ?: "-"}"
                )
                Text(
                    text = "New: ${log.newData ?: "-"}"
                )
                Divider()
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            viewModel.hapusSemuaAuditLog()
        }) {
            Text("Hapus Semua Log")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Kembali")
        }
    }
}
