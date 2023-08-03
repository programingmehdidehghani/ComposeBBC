package com.example.samplecompose.data.repository

import com.example.samplecompose.data.api.ApiService
import com.example.samplecompose.data.db.FavoriteDB
import com.example.samplecompose.data.models.Article
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImp (private val apiService: ApiService,
   private val favoriteDB: FavoriteDB) : NewsRepository {


    override suspend fun getResultSearch(searchQuery :String ,pageNumber :Int): NewsResponse =
        apiService.searchForNews(searchQuery,pageNumber)

    override suspend fun insertFavorite(article: MutableList<Article>) {
        favoriteDB.getRunDao().insertArticle(article)
    }
}