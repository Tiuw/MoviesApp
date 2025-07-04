// app/src/main/java/com/belajar/moviesapp/domain/model/Movie.kt
package com.belajar.moviesapp.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String?,
    val releaseDate: String,
    val voteAverage: Float,
    val isFavorite: Boolean = false
)