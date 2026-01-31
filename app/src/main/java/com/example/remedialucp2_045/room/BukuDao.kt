package com.example.remedialucp2_045.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BukuDao {

    @Query("SELECT * FROM buku WHERE isDeleted = 0")
    fun getAllBuku(): Flow<List<Buku>>

    @Query("SELECT * FROM buku WHERE bukuId = :id AND isDeleted = 0")
    fun getBukuById(id: Long): Flow<Buku?>

    @Insert
    suspend fun insert(buku: Buku)

    @Update
    suspend fun update(buku: Buku)

    @Query("UPDATE buku SET isDeleted = 1 WHERE bukuId = :id")
    suspend fun softDelete(id: Long)
}
