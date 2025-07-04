// app/src/main/java/com/belajar/moviesapp/domain/repository/MovieRepository.kt
package com.belajar.moviesapp.domain.repository

import com.belajar.moviesapp.domain.model.Movie
import com.belajar.moviesapp.domain.model.MovieDetail

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): List<Movie>
    suspend fun getMovieDetails(movieId: Int): MovieDetail
    suspend fun searchMovies(query: String): List<Movie>
    suspend fun getFavoriteMovies(): List<Movie>
    suspend fun addToFavorites(movie: Movie): Boolean
    suspend fun removeFromFavorites(movieId: Int): Boolean
    suspend fun isMovieFavorite(movieId: Int): Boolean
}