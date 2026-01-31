package com.example.remedialucp2_045.room

import androidx.room.Entity

@Entity(
    tableName = "penulisbuku",
    primaryKeys = ["bukuId", "penulisId"]
)
data class PenulisBuku(
    val bukuId: Long,
    val penulisId: Long
)
