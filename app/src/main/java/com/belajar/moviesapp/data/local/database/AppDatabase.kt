package com.belajar.moviesapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.belajar.moviesapp.data.local.dao.MovieDao
import com.belajar.moviesapp.data.local.entity.GenreConverter
import com.belajar.moviesapp.data.local.entity.MovieDetailEntity
import com.belajar.moviesapp.data.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class, MovieDetailEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(GenreConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}