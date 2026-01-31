package com.example.remedialucp2_045.ui.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remedialucp2_045.repositori.RemedPAM
import com.example.remedialucp2_045.ui.viewmodel.AuditLogViewModel
import com.example.remedialucp2_045.ui.viewmodel.BukuViewModel
import com.example.remedialucp2_045.ui.viewmodel.PerpustakaanViewModel


object PenyediaViewModel {

    val Factory = viewModelFactory {

        initializer {
            PerpustakaanViewModel(
                remedApp().container.repositoriKategori
            )
        }

        // ViewModel Buku
        initializer {
            BukuViewModel(
                remedApp().container.repositoriBuku
            )
        }

        // ViewModel Audit Log
        initializer {
            AuditLogViewModel(
                remedApp().container.repositoriAuditLog
            )
        }
    }
}


fun CreationExtras.remedApp(): RemedPAM =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RemedPAM)
