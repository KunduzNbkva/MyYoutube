package com.example.myyoutube.ui.playlists

import androidx.lifecycle.MutableLiveData
import com.example.myyoutube.base.BaseViewModel
import com.example.myyoutube.data.models.PlaylistItems
import com.example.myyoutube.data.network.Status
import com.example.myyoutube.data.repository.YoutubeRepository

class PlaylistViewModel(private val repository: YoutubeRepository) : BaseViewModel() {
     var playlists = MutableLiveData<MutableList<PlaylistItems>>()

     init {
         fetchPlaylists()
     }

    private fun fetchPlaylists() {
        repository.fetchPlaylists().observeForever {
            when (it.status) {
                Status.SUCCESS -> playlists.postValue(it.data?.items!!)
                Status.ERROR-> errorMessage.postValue(it.message.toString())
            }
        }
    }
}