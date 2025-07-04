// app/src/main/java/com/belajar/moviesapp/domain/usecase/GetPopularMoviesUseCase.kt
package com.belajar.moviesapp.domain.usecase

import com.belajar.moviesapp.domain.model.Movie
import com.belajar.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(page: Int = 1): List<Movie> {
        return repository.getPopularMovies(page)
    }
}