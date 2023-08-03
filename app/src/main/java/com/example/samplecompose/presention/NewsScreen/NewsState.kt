package com.example.samplecompose.presention.NewsScreen

import com.example.samplecompose.data.models.Article

data class NewsState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""
)
