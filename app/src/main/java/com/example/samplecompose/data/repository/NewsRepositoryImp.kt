package com.example.samplecompose.data.repository

import com.example.samplecompose.data.api.ApiService
import com.example.samplecompose.data.db.FavouriteDB
import com.example.samplecompose.data.models.Article
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp (private val apiService: ApiService,
   private val favouriteDB: FavouriteDB) : NewsRepository {


    override suspend fun getResultSearch(searchQuery :String ,pageNumber :Int): NewsResponse =
        apiService.searchForNews(searchQuery,pageNumber)

    override suspend fun insertFavorite(article: MutableList<Article>) {
        favouriteDB.getRunDao().insertArticle(article)
    }

    override suspend fun getListArticleFromDB(): Flow<List<Article>> =
        favouriteDB.getRunDao().getTestContentNews()

}