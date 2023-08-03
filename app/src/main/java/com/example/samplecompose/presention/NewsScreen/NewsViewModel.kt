package com.example.samplecompose.presention.NewsScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecompose.data.models.Article
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.newsUseCase.InsertFavoriteUseCase
import com.example.samplecompose.doamin.newsUseCase.ResultSearchUseCase
import com.example.samplecompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor (
    private val resultSearchUseCase: ResultSearchUseCase,
    private val insertFavoriteUseCase: InsertFavoriteUseCase
) : ViewModel(){

    private val _state = mutableStateOf(NewsState())
    val state: State<NewsState> = _state


    fun getResultSearchQuery(searchQuery: String, pageNumber: Int) {
        resultSearchUseCase(searchQuery, pageNumber).onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = NewsState(isLoading = true)
                is Resource.Success<*> -> {
                    result.data.let {
                        val response = result.data as NewsResponse
                        val articles = response.articles
                        _state.value = NewsState(articles = articles.toMutableList())
                    }
                }
                is Resource.Error -> _state.value = NewsState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }

    fun insertFavorite(article: MutableList<Article>) {
        insertFavoriteUseCase(article).onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = NewsState(isLoading = true)
                is Resource.Success<*> -> {
                    result.data.let {
                        val response = result.data as NewsResponse
                        val articles = response.articles
                        _state.value = NewsState(articles = articles.toMutableList())
                    }
                }
                is Resource.Error -> _state.value = NewsState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }

}