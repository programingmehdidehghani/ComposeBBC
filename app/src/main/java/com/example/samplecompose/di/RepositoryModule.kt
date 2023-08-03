package com.example.samplecompose.di

import com.example.samplecompose.data.api.ApiService
import com.example.samplecompose.data.db.FavoriteDB
import com.example.samplecompose.data.repository.NewsRepositoryImp
import com.example.samplecompose.doamin.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(apiService: ApiService, favoriteDB: FavoriteDB) : NewsRepository {
        return NewsRepositoryImp(apiService,favoriteDB)
    }

}