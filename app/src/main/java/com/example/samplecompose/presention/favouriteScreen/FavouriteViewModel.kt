package com.example.samplecompose.presention.favouriteScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecompose.data.models.NewsResponse
import com.example.samplecompose.doamin.newsUseCase.GetArticleDBUseCase
import com.example.samplecompose.presention.NewsScreen.NewsState
import com.example.samplecompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class FavouriteViewModel @Inject constructor (
    private val getArticleDBUseCase: GetArticleDBUseCase,
) : ViewModel(){

    private val _state = mutableStateOf(FavouriteState())
    val state: State<FavouriteState> = _state

    init {
        getResultSearchQuery()
    }


    private fun getResultSearchQuery() {
        getArticleDBUseCase().onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = FavouriteState(isLoading = true)
                is Resource.Success<*> -> {
                    result.data.let {
                        val response = result.data as NewsResponse
                        val articles = response.articles
                        _state.value = FavouriteState(articles = articles.toMutableList())
                    }
                }
                is Resource.Error -> _state.value = FavouriteState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }


}