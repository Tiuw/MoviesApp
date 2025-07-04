// app/src/main/java/com/belajar/moviesapp/data/remote/datasource/MovieRemoteDataSource.kt
package com.belajar.moviesapp.data.remote.datasource

import com.belajar.moviesapp.data.remote.api.MovieApiService
import com.belajar.moviesapp.data.remote.model.toDomainModel
import com.belajar.moviesapp.domain.model.Movie
import com.belajar.moviesapp.domain.model.MovieDetail
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val apiService: MovieApiService
) {
    suspend fun fetchPopularMovies(page: Int): List<Movie> {
        return apiService.getPopularMovies(page).results.map { it.toDomainModel() }
    }

    suspend fun fetchMovieDetails(movieId: Int): MovieDetail {
        return apiService.getMovieDetails(movieId).toDomainModel()
    }

    suspend fun searchMovies(query: String): List<Movie> {
        return apiService.searchMovies(query).results.map { it.toDomainModel() }
    }
}