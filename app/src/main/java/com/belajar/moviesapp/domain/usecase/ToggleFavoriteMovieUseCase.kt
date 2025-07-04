// app/src/main/java/com/belajar/moviesapp/domain/usecase/ToggleFavoriteMovieUseCase.kt
package com.belajar.moviesapp.domain.usecase

import com.belajar.moviesapp.domain.model.Movie
import com.belajar.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class ToggleFavoriteMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie): Boolean {
        val isFavorite = repository.isMovieFavorite(movie.id)

        return if (isFavorite) {
            repository.removeFromFavorites(movie.id)
            false
        } else {
            repository.addToFavorites(movie)
            true
        }
    }
}