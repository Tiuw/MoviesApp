// app/src/main/java/com/belajar/moviesapp/data/remote/api/MovieApiService.kt
package com.belajar.moviesapp.data.remote.api

import com.belajar.moviesapp.data.remote.model.MovieDetailResponse
import com.belajar.moviesapp.data.remote.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): MovieDetailResponse

    @GET("search/movie")
    suspend fun searchMovies(@Query("query") query: String): MovieResponse
}