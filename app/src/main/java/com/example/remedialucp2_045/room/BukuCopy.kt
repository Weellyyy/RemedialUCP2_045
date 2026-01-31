package com.example.remedialucp2_045.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Buku_Copy")
data class BukuCopy(
    @PrimaryKey(autoGenerate = true)
    val copyId: Long = 0,
    val bukuId: Long,
    val status: String
)
