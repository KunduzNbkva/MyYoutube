package com.example.myyoutube.data.local

import android.content.Context
import androidx.room.Room

class DataBaseClient {
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    fun providePlaylistDao(db: AppDatabase): PlaylistDao = db.playlistDao()
}