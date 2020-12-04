package com.example.myyoutube.ui.detailVideo

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.NonNull
import com.example.myyoutube.R
import com.example.myyoutube.base.BaseActivity
import com.example.myyoutube.data.models.DetailVideo
import com.example.myyoutube.layoutParams
import com.example.myyoutube.ui.detailPlaylist.DetailPlaylistActivity
import com.example.myyoutube.ui.playlists.PlaylistViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_detail_video.*

class DetailVideoActivity : BaseActivity<PlaylistViewModel>(R.layout.activity_detail_video,PlaylistViewModel::class) {

    override fun setupLiveData() {
    }

    override fun setupViews() {
        getVideo()
    }

    private fun getVideo() {
        initPlayer(item?.snippet?.resourceId?.videoId.toString())
    }

    private fun initPlayer(id:String) {
        lifecycle.addObserver(player_view)
        player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(id,0F)
            }
        })
        title_video.text= item?.snippet?.title
        video_description.text= item?.snippet?.description
    }

    override fun setupFetchRequests() {
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == ORIENTATION_LANDSCAPE) {
            supportActionBar?.hide()
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            player_view?.layoutParams {
                width = ViewGroup.LayoutParams.MATCH_PARENT
                height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
        }

        if (newConfig.orientation == ORIENTATION_PORTRAIT) {
            supportActionBar?.show()
            player_view?.layoutParams {
                width = ViewGroup.LayoutParams.MATCH_PARENT
                height = ViewGroup.LayoutParams.MATCH_PARENT
            }
        }

    }

    companion object {
        var item: DetailVideo? = null
        fun instanceActivity(activity: Activity?, video: DetailVideo) {
            val intent = Intent(activity, DetailVideoActivity::class.java)
            intent.putExtra("video",item)
            this.item = video
            activity?.startActivity(intent)
        }
    }
}


