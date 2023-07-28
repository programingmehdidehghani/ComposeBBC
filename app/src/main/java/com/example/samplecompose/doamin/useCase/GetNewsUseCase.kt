package com.example.samplecompose.doamin.useCase

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
            emit(Resource.Success(newsRepository.getBreakNews(countryCode,pageNumber)))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}