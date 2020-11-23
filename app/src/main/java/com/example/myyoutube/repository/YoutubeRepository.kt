package com.example.myyoutube.repository

import androidx.lifecycle.MutableLiveData
import com.example.myyoutube.models.Playlist
import com.example.myyoutube.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class YoutubeRepository() {

    val channel = "UCstOGCiUPl-CxCxX8lb7zdA"
    val key = "AIzaSyAx8p70xc-SuyvmfhLZbCCJNiqQOQG0nj0"
    val part = "snippet,contentDetails"
    val maxResult = "50"


    private var api = RetrofitClient().instanceRetrofit()

    fun fetchPlaylistsFromNetwork(): MutableLiveData<Playlist?> {
        val data = MutableLiveData<Playlist?>()
        api.fetchPlaylists(part, key, channel, maxResult).enqueue(object : Callback<Playlist?> {
            override fun onFailure(call: Call<Playlist?>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<Playlist?>, response: Response<Playlist?>) {
                data.value = response.body()
            }

        })
        return data
    }

}