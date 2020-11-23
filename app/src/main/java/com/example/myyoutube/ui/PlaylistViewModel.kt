package com.example.myyoutube.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myyoutube.models.Playlist
import com.example.myyoutube.repository.YoutubeRepository

class PlaylistViewModel: ViewModel(){
    fun fetchPlaylists(): MutableLiveData<Playlist?> {
        return YoutubeRepository().fetchPlaylistsFromNetwork()
    }
}