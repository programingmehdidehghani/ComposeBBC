package com.example.samplecompose.doamin.newsUseCase

import com.example.samplecompose.data.models.Article
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.repository.NewsRepository
import com.example.samplecompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class InsertFavoriteUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(article: MutableList<Article>): Flow<Resource<NewsResponse>> = flow {

        try {
            emit(Resource.Loading)
            newsRepository.insertFavorite(article)
            val newsResponse = NewsResponse(
                status = "ok",
                totalResults = article.size,
                articles = article
            )
            emit(Resource.Success(newsResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}