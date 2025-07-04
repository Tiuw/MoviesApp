// MovieDto.kt
package com.belajar.moviesapp.data.remote.model

import com.belajar.moviesapp.domain.model.Genre
import com.belajar.moviesapp.domain.model.Movie
import com.belajar.moviesapp.domain.model.MovieDetail
import com.squareup.moshi.Json

data class MovieResponse(
    val page: Int,
    val results: List<MovieDto>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)

data class MovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "vote_average") val voteAverage: Float
)

data class MovieDetailResponse(
    val id: Int,
    val title: String,
    val overview: String,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "vote_average") val voteAverage: Float,
    val runtime: Int?,
    val genres: List<GenreDto>
)

data class GenreDto(
    val id: Int,
    val name: String
)

// Mapper functions
fun MovieDto.toDomainModel(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath ?: "",
        backdropPath = backdropPath,
        releaseDate = releaseDate ?: "",
        voteAverage = voteAverage
    )
}

fun MovieDetailResponse.toDomainModel(): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath ?: "",
        backdropPath = backdropPath,
        releaseDate = releaseDate ?: "",
        voteAverage = voteAverage,
        runtime = runtime,
        genres = genres.map { Genre(it.id, it.name) }
    )
}