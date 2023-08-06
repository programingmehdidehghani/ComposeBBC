package com.example.samplecompose.presention.newsScreen

import com.example.samplecompose.data.models.Article

data class NewsState(
    val isLoading: Boolean = false,
    val articles: MutableList<Article> = arrayListOf(),
    val error: String = ""
)
