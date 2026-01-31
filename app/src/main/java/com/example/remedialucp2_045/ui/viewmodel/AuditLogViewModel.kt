package com.example.remedialucp2_045.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_045.repositori.RepositoriAuditLog
import com.example.remedialucp2_045.room.AuditLog
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AuditLogViewModel(
    private val repositoriAuditLog: RepositoriAuditLog
) : ViewModel() {

    val auditLogList: StateFlow<List<AuditLog>> =
        repositoriAuditLog.getAllAuditLogStream()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun tambahAuditLog(
        tableName: String,
        action: String,
        oldData: String?,
        newData: String?
    ) {
        viewModelScope.launch {
            repositoriAuditLog.insertAuditLog(
                AuditLog(
                    tableName = tableName,
                    action = action,
                    oldData = oldData,
                    newData = newData
                )
            )
        }
    }

    fun hapusSemuaAuditLog() {
        viewModelScope.launch {
            repositoriAuditLog.clearAuditLog()
        }
    }
}
