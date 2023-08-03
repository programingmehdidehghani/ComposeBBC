package com.example.samplecompose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.samplecompose.data.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class FavoriteDB : RoomDatabase() {

    abstract fun getRunDao() : FavoriteDAO
}