package com.example.myyoutube.network

import com.example.myyoutube.models.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface  YoutubeApi{

    @GET("youtube/v3/playlists")
    fun fetchPlaylists(
        @Query("part") part: String,
        @Query("key") key: String,
        @Query("channelId") channelId: String,
        @Query("maxResult") maxResult: String
    ): Call<Playlist>
}