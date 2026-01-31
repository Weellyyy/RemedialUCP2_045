package com.example.remedialucp2_045.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface KategoriDao {

    @Query("SELECT * FROM kategori WHERE isDeleted = 0")
    fun getAllCategories(): Flow<List<Kategori>>

    @Query("SELECT * FROM kategori WHERE kategoriId = :id")
    fun getCategory(id: Long): Flow<Kategori?>

    @Insert
    suspend fun insert(kategori: Kategori)

    @Update
    suspend fun update(kategori: Kategori)

    @Query("UPDATE kategori SET isDeleted = 1 WHERE kategoriId = :id")
    suspend fun softDelete(id: Long)
}
