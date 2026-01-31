package com.example.remedialucp2_045.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Kategori::class,
        Buku::class,
        BukuCopy::class,
        Penulis::class,
        PenulisBuku::class,
        AuditLog::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun kategoriDao(): KategoriDao
    abstract fun bukuDao(): BukuDao
    abstract fun auditlogDao(): AuditLogDao

    companion object {

        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "perpustakaan_db"
                )
                    .build()
                    .also { Instance = it }
            })
        }
    }
}
