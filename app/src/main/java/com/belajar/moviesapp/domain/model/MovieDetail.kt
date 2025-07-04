// app/src/main/java/com/belajar/moviesapp/domain/model/MovieDetail.kt
package com.belajar.moviesapp.domain.model

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String?,
    val releaseDate: String,
    val voteAverage: Float,
    val runtime: Int?,
    val genres: List<Genre>
)

data class Genre(
    val id: Int,
    val name: String
)