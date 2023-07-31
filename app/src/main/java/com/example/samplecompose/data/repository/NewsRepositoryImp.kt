package com.example.samplecompose.data.repository

import com.example.samplecompose.data.api.ApiService
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImp (private val apiService: ApiService) : NewsRepository {


    override suspend fun getBreakNews(countryCode :String ,pageNumber :Int): NewsResponse =
        apiService.getBreakingNews(countryCode,pageNumber)
}