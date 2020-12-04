package com.example.myyoutube.ui.detailPlaylist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.myyoutube.R
import com.example.myyoutube.data.models.DetailVideo
import com.example.myyoutube.loadImage
import com.example.myyoutube.ui.detailPlaylist.adapter.DetailAdapter
import com.example.myyoutube.ui.detailVideo.DetailVideoActivity
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.content_scrolling.*
import org.koin.android.ext.android.inject

class DetailPlaylistActivity() : AppCompatActivity() {

    private val viewModel by inject<DetailPlaylistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        subscribeDetailPlaylist()
        initToolbar()
        viewModel.fetchDetailPlaylist(playListId, null)
    }

    private fun initToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = ""
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initRecycler(list:MutableList< DetailVideo>) {
        val adapter = DetailAdapter(this::onItemClick)
        adapter.addItems(list)
        list[0].snippet?.thumbnails?.medium?.url?.let { playlists_image.loadImage(it) }
        videos_rv.adapter = adapter
    }

    private fun subscribeDetailPlaylist() {
        viewModel.detailPlaylists.observeForever {
            initRecycler(it)
        }
    }

    private fun onItemClick(item: DetailVideo) {
       DetailVideoActivity.instanceActivity(this, item)
    }

    companion object {
        var playListId: String? = null
        var title: String? = null
        fun instanceActivity(activity: Activity?, playListId: String, title: String) {
            val intent = Intent(activity, DetailPlaylistActivity::class.java)
            this.playListId = playListId
            this.title = title
            activity?.startActivity(intent)
        }

    }
}