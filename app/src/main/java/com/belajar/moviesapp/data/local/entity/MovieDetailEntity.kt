// app/src/main/java/com/belajar/moviesapp/data/local/entity/MovieDetailEntity.kt
package com.belajar.moviesapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.belajar.moviesapp.domain.model.Genre
import com.belajar.moviesapp.domain.model.MovieDetail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "movie_details")
data class MovieDetailEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String?,
    val releaseDate: String,
    val voteAverage: Float,
    val runtime: Int?,
    val genres: String  // JSON string of genres
)

fun MovieDetailEntity.toDomainModel(): MovieDetail {
    val genreList = GenreConverter().fromString(genres)
    return MovieDetail(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        runtime = runtime,
        genres = genreList
    )
}

fun MovieDetail.toEntity(): MovieDetailEntity {
    return MovieDetailEntity(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        runtime = runtime,
        genres = GenreConverter().toString(genres)
    )
}

class GenreConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String): List<Genre> {
        val listType = object : TypeToken<List<Genre>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun toString(genres: List<Genre>): String {
        return gson.toJson(genres)
    }
}