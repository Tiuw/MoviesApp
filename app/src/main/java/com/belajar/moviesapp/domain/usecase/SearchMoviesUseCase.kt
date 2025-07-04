// app/src/main/java/com/belajar/moviesapp/domain/usecase/SearchMoviesUseCase.kt
package com.belajar.moviesapp.domain.usecase

import com.belajar.moviesapp.domain.model.Movie
import com.belajar.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(query: String): List<Movie> {
        return repository.searchMovies(query)
    }
}