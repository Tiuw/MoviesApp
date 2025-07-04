// app/src/main/java/com/belajar/moviesapp/domain/usecase/GetMovieDetailsUseCase.kt
package com.belajar.moviesapp.domain.usecase

import com.belajar.moviesapp.domain.model.MovieDetail
import com.belajar.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): MovieDetail {
        return repository.getMovieDetails(movieId)
    }
}