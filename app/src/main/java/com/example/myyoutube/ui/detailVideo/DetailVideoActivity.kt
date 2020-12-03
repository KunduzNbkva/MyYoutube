package com.example.myyoutube.ui.detailVideo

import android.app.Activity
import android.content.Intent
import com.example.myyoutube.R
import com.example.myyoutube.base.BaseActivity
import com.example.myyoutube.data.models.DetailVideo
import com.example.myyoutube.data.models.PlaylistItems
import com.example.myyoutube.data.models.YoutubeVideo
import com.example.myyoutube.ui.detailPlaylist.DetailPlaylistActivity
import com.example.myyoutube.ui.playlists.PlaylistViewModel
import kotlinx.android.synthetic.main.activity_detail_video.*

class DetailVideoActivity : BaseActivity<PlaylistViewModel>(R.layout.activity_detail_video,PlaylistViewModel::class){
    val urlsArray= mutableListOf<YoutubeVideo>()
    override fun setupLiveData() {
        titleVideo.text=playListItems?.snippet?.title
        description_video.text= playListItems?.snippet?.description

    }

    override fun setupViews() {
    }

    override fun setupFetchRequests() {
    }

    companion object{
        var playListItems:PlaylistItems?=null
        fun instanceActivity(activity: Activity?, item:DetailVideo){
            val intent = Intent(activity, DetailPlaylistActivity::class.java)
            this.playListItems = playListItems
            activity?.startActivity(intent)
        }
    }
}