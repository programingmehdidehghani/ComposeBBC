package com.example.samplecompose.doamin.repository

import com.example.samplecompose.data.models.Article
import com.example.samplecompose.data.models.NewsResponse
import retrofit2.Response

interface NewsRepository {


    suspend fun getResultSearch(searchQuery : String , pageNumber : Int): NewsResponse

    suspend fun insertFavorite(article: MutableList<Article>)


}