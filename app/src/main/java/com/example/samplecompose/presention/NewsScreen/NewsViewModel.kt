package com.example.samplecompose.presention.NewsScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.newsUseCase.GetNewsUseCase
import com.example.samplecompose.doamin.newsUseCase.ResultSearchUseCase
import com.example.samplecompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor (
    private val getNewsUseCase: GetNewsUseCase,
    private val resultSearchUseCase: ResultSearchUseCase
) : ViewModel(){

    private val _state = mutableStateOf(NewsState())
    val state: State<NewsState> = _state

    init {
        getNews("us",1)
    }
    private fun getNews(countryCode: String, pageNumber: Int) {
        getNewsUseCase(countryCode, pageNumber).onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = NewsState(isLoading = true)
                is Resource.Success<*> -> {
                    result.data.let {
                        val response = result.data as NewsResponse
                        val articles = response.articles
                        _state.value = NewsState(articles = articles.toMutableList())
                        Log.i("result","${articles.size}")
                    }
                }
                is Resource.Error -> _state.value = NewsState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }

    fun getResultSearchQuery(searchQuery: String, pageNumber: Int) {
        resultSearchUseCase(searchQuery, pageNumber).onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = NewsState(isLoading = true)
                is Resource.Success<*> -> {
                    result.data.let {
                        val response = result.data as NewsResponse
                        val articles = response.articles
                        _state.value = NewsState(articles = articles.toMutableList())
                        Log.i("result","${articles.size}")
                    }
                }
                is Resource.Error -> _state.value = NewsState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }

}