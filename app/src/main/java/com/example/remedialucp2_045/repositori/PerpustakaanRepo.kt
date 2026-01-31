package com.example.remedialucp2_045.repositori

import com.example.remedialucp2_045.room.Kategori
import com.example.remedialucp2_045.room.KategoriDao
import kotlinx.coroutines.flow.Flow

interface RepositoriKategori {

    fun getAllKategoriStream(): Flow<List<Kategori>>

    fun getKategoriStream(id: Long): Flow<Kategori?>

    suspend fun insertKategori(kategori: Kategori)

    suspend fun updateKategori(kategori: Kategori)

    suspend fun deleteKategori(kategori: Kategori)
}
class OfflineRepositoriKategori(
    private val kategoriDao: KategoriDao
) : RepositoriKategori {

    override fun getAllKategoriStream(): Flow<List<Kategori>> =
        kategoriDao.getAllCategories()

    override fun getKategoriStream(id: Long): Flow<Kategori?> =
        kategoriDao.getCategory(id)

    override suspend fun insertKategori(kategori: Kategori) =
        kategoriDao.insert(kategori)

    override suspend fun updateKategori(kategori: Kategori) =
        kategoriDao.update(kategori)

    override suspend fun deleteKategori(kategori: Kategori) =
        kategoriDao.softDelete(kategori.KategoriId)
}