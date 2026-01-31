package com.example.remedialucp2_045.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buku")
data class Buku(
    @PrimaryKey(autoGenerate = true)
    val bukuId: Long = 0,
    val judul: String,
    val KategoriId: Long?,
    val isDeleted: Boolean = false
)
