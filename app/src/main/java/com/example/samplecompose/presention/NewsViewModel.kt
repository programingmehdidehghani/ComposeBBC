package com.example.samplecompose.presention

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
    private fun getNews(countryCode : String , pageNumber : Int){
        getNewsUseCase("us",1).onEach {result ->
            when(result){
                Resource.Loading -> _state.value = HomeState(isLoading = false)
                is Resource.Success<*> ->{
                    result.data.let {
                        _state.value = HomeState(agents = it as List<NewsResponse>)
                        allAgents = it
                    }
                }
                is Resource.Error -> _state.value = HomeState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }

}