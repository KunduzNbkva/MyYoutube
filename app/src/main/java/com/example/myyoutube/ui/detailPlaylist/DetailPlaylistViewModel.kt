package com.example.myyoutube.ui.detailPlaylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myyoutube.data.models.DetailPlayList
import com.example.myyoutube.data.models.DetailVideo
import com.example.myyoutube.data.models.PlaylistItems
import com.example.myyoutube.data.network.Status
import com.example.myyoutube.data.repository.YoutubeRepository

class DetailPlaylistViewModel(var repository: YoutubeRepository) : ViewModel() {
    var detailPlaylists = MutableLiveData<MutableList<DetailVideo>>()
    var playlistId: String? = null
    var detail: MutableList<PlaylistItems>? = mutableListOf()

    fun fetchDetailPlaylist(playListId: String?, nextPageToken: String?) {
        repository.fetchDetailPlaylists(playListId, nextPageToken).observeForever {
            when (it.status) {
                Status.SUCCESS -> detailPlaylists.value =it.data?.items!!
                Status.ERROR -> error(it.message.toString())
            }
        }
    }

    private fun getAllVideo(data: PlaylistItems?) {
        data?.let { detail?.addAll(listOf(it)) }
        fetchDetailPlaylist(
            playlistId,
            data?.nextPageToken
        )
        //else detailPlaylists.value = detail
    }
}