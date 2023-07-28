package com.example.samplecompose.presention

import com.example.samplecompose.data.models.NewsResponse

data class HomeState(
    val isLoading: Boolean = false,
    val agents: List<NewsResponse> = emptyList(),
    val error: String = ""
)
