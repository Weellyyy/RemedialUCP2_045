package com.example.remedialucp2_045.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_045.repositori.RepositoriKategori
import com.example.remedialucp2_045.room.Kategori
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PerpustakaanViewModel(
    private val repositoriKategori: RepositoriKategori
) : ViewModel() {

    val kategoriUiState: StateFlow<List<Kategori>> =
        repositoriKategori.getAllKategoriStream()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun getKategoriById(id: Long): StateFlow<Kategori?> =
        repositoriKategori.getKategoriStream(id)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null
            )

    fun insertKategori(kategori: Kategori) {
        viewModelScope.launch {
            repositoriKategori.insertKategori(kategori)
        }
    }

    fun updateKategori(kategori: Kategori) {
        viewModelScope.launch {
            repositoriKategori.updateKategori(kategori)
        }
    }

    fun deleteKategori(kategori: Kategori) {
        viewModelScope.launch {
            repositoriKategori.deleteKategori(kategori)
        }
    }
}
