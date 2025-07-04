// app/src/main/java/com/belajar/moviesapp/data/repository/MovieRepositoryImpl.kt
package com.belajar.moviesapp.data.repository

import com.belajar.moviesapp.data.local.dao.MovieDao
import com.belajar.moviesapp.data.local.entity.toEntity
import com.belajar.moviesapp.data.local.entity.toDomainModel
import com.belajar.moviesapp.data.remote.datasource.MovieRemoteDataSource
import com.belajar.moviesapp.domain.model.Movie
import com.belajar.moviesapp.domain.model.MovieDetail
import com.belajar.moviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieDao
) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return try {
            val movies = remoteDataSource.fetchPopularMovies(page)
            localDataSource.insertMovies(movies.map { it.toEntity(isPopular = true) })
            movies
        } catch (e: Exception) {
            localDataSource.getPopularMovies().map { it.toDomainModel() }
        }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return try {
            val movieDetail = remoteDataSource.fetchMovieDetails(movieId)
            localDataSource.insertMovieDetail(movieDetail.toEntity())
            movieDetail
        } catch (e: Exception) {
            localDataSource.getMovieDetailById(movieId)?.toDomainModel()
                ?: throw Exception("Movie details not found")
        }
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        return remoteDataSource.searchMovies(query)
    }

    override suspend fun getFavoriteMovies(): List<Movie> {
        return localDataSource.getFavoriteMovies().first().map { it.toDomainModel() }
    }

    override suspend fun addToFavorites(movie: Movie): Boolean {
        return try {
            localDataSource.insertFavoriteMovie(movie.toEntity().copy(isFavorite = true))
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun removeFromFavorites(movieId: Int): Boolean {
        return try {
            localDataSource.removeFavoriteMovie(movieId)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun isMovieFavorite(movieId: Int): Boolean {
        return localDataSource.isMovieFavorite(movieId).first()
    }
}