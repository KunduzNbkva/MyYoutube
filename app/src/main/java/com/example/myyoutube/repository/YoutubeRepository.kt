package com.example.myyoutube.repository

import androidx.lifecycle.liveData
import com.example.myyoutube.network.Resource
import com.example.myyoutube.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception


class YoutubeRepository {

    private val channel = "UCRQsPzh6NU4pk2KvebBahtw"
    private val key = "AIzaSyAx8p70xc-SuyvmfhLZbCCJNiqQOQG0nj0"
    private val part = "snippet,contentDetails"
    private val maxResult = "50"


    private var api = RetrofitClient().instanceRetrofit()

    fun fetchPlaylists()= liveData(Dispatchers.IO){
        emit(Resource.loading(data=null))
        try {
         emit(Resource.success(data=api.fetchPlaylists(part,key,channel,maxResult)))
        }catch (e:Exception){
            emit(Resource.error(data=null,message = e.message?:"Error"))
        }
    }
    fun fetchDetailPlaylists(playlistId: String?, pageToken: String?) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.fetchDetailPlaylist(part, key, playlistId, pageToken)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message =  e.message ?: "Error"))
        }
    }


}