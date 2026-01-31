package com.example.remedialucp2_045.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_045.repositori.RepositoriBuku
import com.example.remedialucp2_045.room.Buku
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BukuViewModel(
    private val repositoriBuku: RepositoriBuku
) : ViewModel() {

    val bukuList: StateFlow<List<Buku>> =
        repositoriBuku.getAllBukuStream()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun getBukuById(id: Long): StateFlow<Buku?> =
        repositoriBuku.getBukuStream(id)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null
            )

    fun insertBuku(buku: Buku) {
        viewModelScope.launch {
            repositoriBuku.insertBuku(buku)
        }
    }

    fun updateBuku(buku: Buku) {
        viewModelScope.launch {
            repositoriBuku.updateBuku(buku)
        }
    }

    fun deleteBuku(buku: Buku) {
        viewModelScope.launch {
            repositoriBuku.deleteBuku(buku)
        }
    }
}
