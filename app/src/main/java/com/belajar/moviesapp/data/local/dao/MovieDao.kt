// app/src/main/java/com/belajar/moviesapp/data/local/dao/MovieDao.kt
package com.belajar.moviesapp.data.local.dao

import androidx.room.*
import com.belajar.moviesapp.data.local.entity.MovieDetailEntity
import com.belajar.moviesapp.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE isPopular = 1")
    suspend fun getPopularMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie_details WHERE id = :id")
    suspend fun getMovieDetailById(id: Int): MovieDetailEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movieDetail: MovieDetailEntity)

    @Query("UPDATE movies SET isFavorite = 0 WHERE id = :movieId")
    suspend fun removeFavoriteMovie(movieId: Int)

    @Query("SELECT COUNT(*) > 0 FROM movies WHERE id = :movieId AND isFavorite = 1")
    fun isMovieFavorite(movieId: Int): Flow<Boolean>
}