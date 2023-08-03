package com.example.samplecompose.presention.favouriteScreen

import com.example.samplecompose.data.models.Article

data class FavouriteState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""
)
