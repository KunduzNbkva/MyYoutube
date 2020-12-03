package com.example.myyoutube.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myyoutube.data.models.DetailPlayList
import com.example.myyoutube.data.models.converters.ClassTypeConverter
import com.example.myyoutube.data.models.Playlist
import com.example.myyoutube.data.models.converters.TypeConverterVideo

@Database(entities = [Playlist::class, DetailPlayList::class], version = 1)
@TypeConverters(ClassTypeConverter::class,TypeConverterVideo::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playlistDao(): PlaylistDao
}