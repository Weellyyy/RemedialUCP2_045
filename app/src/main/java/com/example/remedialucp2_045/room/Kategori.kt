package com.example.remedialucp2_045.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kategori")
data class Kategori(
    @PrimaryKey(autoGenerate = true)
    val KategoriId: Long = 0,
    val nama: String,
    val parentId: Long?,
    val isDeleted: Boolean = false
)
