package com.example.samplecompose.presention.favouriteScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.samplecompose.data.models.Article


@Composable
fun FavoriteScreen(
    favouriteViewModel: FavouriteViewModel = hiltViewModel()
){

    val state = favouriteViewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Color.Black
                )
            }
        } else if (state.error.isNotEmpty()) {
            Text(
                text = state.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        } else {
            LazyColumn {
                items(state.articles) { article ->
                    getListFromDB(article = article)
                }
            }
        }

    }



}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun getListFromDB(article: Article) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        GlideImage(model = article.urlToImage, contentDescription = "")
        Text(
            text = article.title.toString(),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = article.author.toString(),
            style = MaterialTheme.typography.caption,
            color = Color.Gray
        )
        Text(
            text = article.description.toString(),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = article.publishedAt.toString(),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
