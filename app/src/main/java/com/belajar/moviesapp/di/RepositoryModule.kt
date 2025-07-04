// app/src/main/java/com/belajar/moviesapp/di/RepositoryModule.kt
package com.belajar.moviesapp.di

import com.belajar.moviesapp.data.repository.MovieRepositoryImpl
import com.belajar.moviesapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}