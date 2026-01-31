package com.example.remedialucp2_045.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "audit_log")
data class AuditLog(
    @PrimaryKey(autoGenerate = true)
    val auditId: Long = 0,

    val tableName: String,
    val action: String,
    val oldData: String?,
    val newData: String?,
    val timestamp: Long = System.currentTimeMillis()
)
