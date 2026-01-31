package com.example.remedialucp2_045.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AuditLogDao {

    @Query("SELECT * FROM audit_log ORDER BY timestamp DESC")
    fun getAllAuditLog(): Flow<List<AuditLog>>

    @Insert
    suspend fun insertAuditLog(auditLog: AuditLog)

    @Query("DELETE FROM audit_log")
    suspend fun clearAuditLog()
}
