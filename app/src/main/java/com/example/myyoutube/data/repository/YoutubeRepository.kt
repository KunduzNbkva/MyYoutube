package com.example.myyoutube.data.repository

import androidx.lifecycle.liveData
import com.example.myyoutube.data.local.PlaylistDao
import com.example.myyoutube.data.network.Resource
import com.example.myyoutube.data.network.YoutubeApi
import kotlinx.coroutines.Dispatchers
import java.lang.Exception


class YoutubeRepository(private var api: YoutubeApi, private var playlistDao: PlaylistDao) {

    private val channel = "UCRQsPzh6NU4pk2KvebBahtw"
    private val key = "AIzaSyAx8p70xc-SuyvmfhLZbCCJNiqQOQG0nj0"
    private val part = "snippet,contentDetails"
    private val maxResult = "50"


    fun fetchPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        emit(Resource.fetchFromDB(playlistDao.getPlaylist()))
        try {
            val request = api.fetchPlaylists(part, key, channel, maxResult)
            playlistDao.insertPlaylist(request)
            emit(Resource.success(data = request))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }
    }

    fun fetchDetailPlaylists(playlistId: String?, pageToken: String?) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        //TODO("add emit to getDetailPlaylist" )
        //emit(Resource.fetchFromDB(playlistDao.getDetailPlaylist()))

        try {
            val detailRequest = api.fetchDetailPlaylist(part, key, playlistId, pageToken)
            playlistDao.insertDetailPlaylist(detailRequest)
            emit(Resource.success(data = detailRequest))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }
    }


}