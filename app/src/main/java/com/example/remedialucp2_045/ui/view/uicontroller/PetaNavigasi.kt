package com.example.remedialucp2_045.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.remedialucp2_045.view.route.DestinasiAuditLog
import com.example.remedialucp2_045.view.route.DestinasiBuku
import com.example.remedialucp2_045.view.route.DestinasiKategori
import com.example.remedialucp2_045.view.screen.AuditLogScreen
import com.example.remedialucp2_045.view.screen.BukuScreen
import com.example.remedialucp2_045.view.screen.KategoriScreen

@Composable
fun PetaNavigasi(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinasiKategori.route,
        modifier = modifier
    ) {
        composable(DestinasiKategori.route) {
            KategoriScreen(navController)
        }

        composable(DestinasiBuku.route) {
            BukuScreen(navController)
        }

        composable(DestinasiAuditLog.route) {
            AuditLogScreen(navController)
        }
    }
}
