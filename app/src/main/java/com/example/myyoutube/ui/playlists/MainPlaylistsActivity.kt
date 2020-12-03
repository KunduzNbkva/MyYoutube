package com.example.myyoutube.ui.playlists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.myyoutube.ui.playlists.adapter.PlaylistsAdapter
import com.example.myyoutube.R
import com.example.myyoutube.data.models.PlaylistItems
import com.example.myyoutube.data.network.Status
import com.example.myyoutube.showToastShort
import com.example.myyoutube.ui.detailPlaylist.DetailPlaylistActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainPlaylistsActivity : AppCompatActivity() {
    private val viewModel by inject<PlaylistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPlaylists()
    }

    private fun initRecycler(list: MutableList<PlaylistItems>) {
        val adapter = PlaylistsAdapter(this::onItemClick)
        adapter.addItems(list)
        playlists_rv.adapter = adapter
    }

    private fun onItemClick(item: PlaylistItems) {
        item.apiId?.let { id ->
            DetailPlaylistActivity.instanceActivity(
                this,
                id,
                item.snippet?.title.toString()
            )
        }

    }

    private fun fetchPlaylists() {
        viewModel.playlists.observeForever {
            initRecycler(it)
        }
    }
}