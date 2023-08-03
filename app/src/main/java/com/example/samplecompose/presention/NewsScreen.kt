package com.example.samplecompose.presention

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.example.samplecompose.data.models.Article


@Composable
fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    if (state.isLoading) {
        CircularProgressIndicator(
         //   modifier = Modifier.align(Alignment.Center),
         //   color = Color.White
        )
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
                ArticleItem(article = article)
            }
        }
    }
}

@Composable
fun ArticleItem(article: Article) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
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
    }
}










