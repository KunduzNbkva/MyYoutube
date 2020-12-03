package com.example.myyoutube.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myyoutube.data.models.DetailPlayList
import com.example.myyoutube.data.models.Playlist
import com.example.myyoutube.data.models.PlaylistItems

@Dao
interface PlaylistDao {
    @Query("SELECT * FROM playlist")
    suspend fun getPlaylist(): Playlist

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylist(items: Playlist)

    @Query("SELECT*FROM detailPlaylist")
    suspend fun getDetailPlaylist():DetailPlayList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertDetailPlaylist(items: DetailPlayList)

}