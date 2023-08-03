package com.example.samplecompose.doamin.newsUseCase

import com.example.samplecompose.data.models.Article
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.data.models.Source
import com.example.samplecompose.doamin.repository.NewsRepository
import com.example.samplecompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArticleDBUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<Resource<NewsResponse>> = flow {
        try {
            emit(Resource.Loading)
            newsRepository.getListArticleFromDB().collect { articles ->
                val newArticle : MutableList<Article> = arrayListOf()
                for (i in articles){
                    val article = Article(
                        id = i.id,
                        author = i.author,
                        content = i.content,
                        description = i.description,
                        publishedAt = i.publishedAt,
                        source = i.source,
                        title = i.title,
                        url = i.url,
                        urlToImage = i.urlToImage
                    )
                    newArticle.add(article)
                }
                val newsResponse = NewsResponse(
                    status = "ok",
                    totalResults = newArticle.size,
                    articles = newArticle
                )
                emit(Resource.Success(newsResponse))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}
