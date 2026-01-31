package com.example.remedialucp2_045.repositori

import com.example.remedialucp2_045.room.Buku
import com.example.remedialucp2_045.room.BukuDao
import kotlinx.coroutines.flow.Flow

interface RepositoriBuku {

    fun getAllBukuStream(): Flow<List<Buku>>

    fun getBukuStream(id: Long): Flow<Buku?>

    suspend fun insertBuku(buku: Buku)

    suspend fun updateBuku(buku: Buku)

    suspend fun deleteBuku(buku: Buku)
}


class OfflineRepositoriBuku(
    private val bukuDao: BukuDao
) : RepositoriBuku {

    override fun getAllBukuStream(): Flow<List<Buku>> =
        bukuDao.getAllBuku()

    override fun getBukuStream(id: Long): Flow<Buku?> =
        bukuDao.getBukuById(id)

    override suspend fun insertBuku(buku: Buku) =
        bukuDao.insert(buku)

    override suspend fun updateBuku(buku: Buku) =
        bukuDao.update(buku)

    override suspend fun deleteBuku(buku: Buku) =
        bukuDao.softDelete(buku.bukuId)
}
