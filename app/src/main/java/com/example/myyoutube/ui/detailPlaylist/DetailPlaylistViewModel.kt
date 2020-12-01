package com.example.myyoutube.ui.detailPlaylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myyoutube.models.Playlist
import com.example.myyoutube.network.Resource
import com.example.myyoutube.repository.YoutubeRepository

class DetailPlaylistViewModel:ViewModel() {
    fun fetchDetailPlayLists(playlistId:String,pageToken:String?): LiveData<Resource<Playlist>> {
        return YoutubeRepository().fetchDetailPlaylists(playlistId,pageToken)
    }
    }