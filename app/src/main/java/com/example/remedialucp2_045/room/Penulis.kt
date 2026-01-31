package com.example.remedialucp2_045.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "penulis")
data class Penulis(
    @PrimaryKey(autoGenerate = true)
    val penulisId: Long = 0,
    val nama: String
)
