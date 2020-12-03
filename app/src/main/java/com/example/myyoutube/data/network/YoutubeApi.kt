package com.example.myyoutube.data.network

import com.example.myyoutube.data.models.DetailPlayList
import com.example.myyoutube.data.models.Playlist
import com.example.myyoutube.data.models.PlaylistItems
import retrofit2.http.GET
import retrofit2.http.Query

interface  YoutubeApi{

    @GET("youtube/v3/playlists")
    suspend fun fetchPlaylists(
        @Query("part") part: String,
        @Query("key") key: String,
        @Query("channelId") channelId: String,
        @Query("maxResult") maxResult: String
    ): Playlist

    @GET("youtube/v3/playlistItems")
    suspend fun fetchDetailPlaylist(
        @Query("part") part: String,
        @Query("key") key: String,
        @Query("playlistId") playlistId: String?,
        @Query("pageToken") pageToken: String?
    ): DetailPlayList
}