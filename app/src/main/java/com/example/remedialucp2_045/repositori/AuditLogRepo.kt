package com.example.remedialucp2_045.repositori

import com.example.remedialucp2_045.room.AuditLog
import com.example.remedialucp2_045.room.AuditLogDao
import kotlinx.coroutines.flow.Flow

interface RepositoriAuditLog {

    fun getAllAuditLogStream(): Flow<List<AuditLog>>

    suspend fun insertAuditLog(auditLog: AuditLog)

    suspend fun clearAuditLog()
}

class OfflineRepositoriAuditLog(
    private val auditLogDao: AuditLogDao
) : RepositoriAuditLog {

    override fun getAllAuditLogStream(): Flow<List<AuditLog>> =
        auditLogDao.getAllAuditLog()

    override suspend fun insertAuditLog(auditLog: AuditLog) =
        auditLogDao.insertAuditLog(auditLog)

    override suspend fun clearAuditLog() =
        auditLogDao.clearAuditLog()
}
