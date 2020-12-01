package com.example.myyoutube.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myyoutube.models.Playlist
import com.example.myyoutube.network.Resource
import com.example.myyoutube.repository.YoutubeRepository

class PlaylistViewModel(): ViewModel(){

    fun fetchPlaylists(): LiveData<Resource<Playlist>> {
        return  YoutubeRepository().fetchPlaylists()
       }
}