// app/src/main/java/com/belajar/moviesapp/domain/usecase/GetFavoriteMoviesUseCase.kt
package com.belajar.moviesapp.domain.usecase

import com.belajar.moviesapp.domain.model.Movie
import com.belajar.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): List<Movie> {
        return repository.getFavoriteMovies()
    }
}