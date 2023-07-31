package com.example.samplecompose.presention

import com.example.samplecompose.data.models.Article

data class HomeState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""
)
