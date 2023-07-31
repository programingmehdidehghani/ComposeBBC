package com.example.samplecompose.presention

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.useCase.GetNewsUseCase
import com.example.samplecompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor (
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel(){

    private var allAgents = listOf<NewsResponse>()
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getNews("us",1)
    }
    private fun getNews(countryCode: String, pageNumber: Int) {
        getNewsUseCase(countryCode, pageNumber).onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = HomeState(isLoading = true)
                is Resource.Success<*> -> {
                    result.data.let {
                        val response = result.data as NewsResponse
                        val articles = response.articles
                        _state.value = HomeState(articles = articles.toMutableList())
                        Log.i("result","${articles.size}")
                    }
                }
                is Resource.Error -> _state.value = HomeState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }

}