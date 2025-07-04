// app/src/main/java/com/belajar/moviesapp/data/remote/model/MovieDetailResponse.kt
package com.belajar.moviesapp.data.remote.model

import com.belajar.moviesapp.domain.model.MovieDetail
import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("release_date") val releaseDate: String,
    val runtime: Int?,
    val genres: List<Genre>,
    val budget: Long,
    val revenue: Long,
    val status: String
)

data class Genre(
    val id: Int,
    val name: String
)

fun MovieDetailResponse.toMovieDetail(): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath ?: "",
        backdropPath = backdropPath ?: "",
        voteAverage = voteAverage,
        releaseDate = releaseDate,
        runtime = runtime ?: 0,
        genres = genres.map { it.name },
        budget = budget,
        revenue = revenue,
        status = status
    )
}