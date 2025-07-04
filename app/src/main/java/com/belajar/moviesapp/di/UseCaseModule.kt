// app/src/main/java/com/belajar/moviesapp/di/UseCaseModule.kt
package com.belajar.moviesapp.di

import com.belajar.moviesapp.domain.repository.MovieRepository
import com.belajar.moviesapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetPopularMoviesUseCase(repository: MovieRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(repository)
    }

    @Provides
    fun provideGetMovieDetailsUseCase(repository: MovieRepository): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(repository)
    }

    @Provides
    fun provideSearchMoviesUseCase(repository: MovieRepository): SearchMoviesUseCase {
        return SearchMoviesUseCase(repository)
    }

    @Provides
    fun provideGetFavoriteMoviesUseCase(repository: MovieRepository): GetFavoriteMoviesUseCase {
        return GetFavoriteMoviesUseCase(repository)
    }

    @Provides
    fun provideToggleFavoriteMovieUseCase(repository: MovieRepository): ToggleFavoriteMovieUseCase {
        return ToggleFavoriteMovieUseCase(repository)
    }
}