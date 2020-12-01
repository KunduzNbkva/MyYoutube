package com.example.myyoutube.ui.playlists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myyoutube.ui.playlists.adapter.PlaylistsAdapter
import com.example.myyoutube.R
import com.example.myyoutube.models.Playlist
import com.example.myyoutube.models.PlaylistItems
import com.example.myyoutube.network.Status
import com.example.myyoutube.showToastShort
import com.example.myyoutube.ui.detailPlaylist.DetailPlaylistActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainPlaylistsActivity : AppCompatActivity() {
    private lateinit var viewModel: PlaylistViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        fetchPlaylists()
    }

    private fun initRecycler(list: MutableList<PlaylistItems>) {
        val adapter = PlaylistsAdapter(this::onItemClick)
        adapter.addItems(list)
        playlists_rv.adapter = adapter
    }

    private fun onItemClick(item: PlaylistItems) {
     DetailPlaylistActivity.instanceActivity(this, item.id.toString(),item.snippet?.title.toString())
    }

    private fun fetchPlaylists() {
        viewModel.fetchPlaylists().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> { it.data?.items?.let { it1 -> initRecycler(it1) } }
                Status.ERROR -> {showToastShort(it?.message.toString()) }
            }
        })
    }


}