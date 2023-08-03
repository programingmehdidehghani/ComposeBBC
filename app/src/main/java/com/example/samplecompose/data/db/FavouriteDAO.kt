package com.example.samplecompose.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.samplecompose.data.models.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: MutableList<Article>)


    @Query("SELECT * FROM articles")
    fun getTestContentNews() : Flow<List<Article>>
}