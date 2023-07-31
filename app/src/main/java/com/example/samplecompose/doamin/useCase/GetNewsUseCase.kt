package com.example.samplecompose.doamin.useCase

import android.util.Log
import com.example.samplecompose.data.models.Article
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.repository.NewsRepository
import com.example.samplecompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(countryCode : String , pageNumber : Int): Flow<Resource<NewsResponse>> = flow {

        try {
            emit(Resource.Loading)
            newsRepository.getBreakNews(countryCode, pageNumber).articles.let {
                val list = mutableListOf<Article>()
                for (i in it) {
                    val article = Article(
                        i.id,
                        i.author,
                        i.content,
                        i.description,
                        i.publishedAt,
                        i.source,
                        i.title,
                        i.url,
                        i.urlToImage
                    )
                    list.add(article)
                }
                val newsResponse = NewsResponse(
                    status = "ok",
                    totalResults = list.size,
                    articles = list
                )
                emit(Resource.Success(newsResponse))
            }

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}