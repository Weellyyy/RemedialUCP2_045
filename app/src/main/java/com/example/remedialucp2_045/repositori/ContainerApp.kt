package com.example.remedialucp2_045.repositori

import android.app.Application
import android.content.Context
import com.example.remedialucp2_045.room.AppDatabase


interface ContainerApp {

    val repositoriKategori: RepositoriKategori
    val repositoriBuku: RepositoriBuku
    val repositoriAuditLog: RepositoriAuditLog
}

class ContainerDataApp(private val context: Context) : ContainerApp {

    override val repositoriKategori: RepositoriKategori by lazy {
        OfflineRepositoriKategori(
            AppDatabase.getDatabase(context).kategoriDao()
        )
    }

    override val repositoriBuku: RepositoriBuku by lazy {
        OfflineRepositoriBuku(
            AppDatabase.getDatabase(context).bukuDao()
        )
    }

    override val repositoriAuditLog: RepositoriAuditLog by lazy {
        OfflineRepositoriAuditLog(
            AppDatabase.getDatabase(context).auditlogDao()
        )
    }
}


class RemedPAM : Application() {

    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}
