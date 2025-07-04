// app/src/main/java/com/belajar/moviesapp/data/local/entity/MovieEntity.kt
package com.belajar.moviesapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.belajar.moviesapp.domain.model.Movie

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String?,
    val releaseDate: String,
    val voteAverage: Float,
    val isPopular: Boolean = false,
    val isFavorite: Boolean = false
)

fun MovieEntity.toDomainModel(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        isFavorite = isFavorite
    )
}

fun Movie.toEntity(isPopular: Boolean = false): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        isPopular = isPopular,
        isFavorite = isFavorite
    )
}