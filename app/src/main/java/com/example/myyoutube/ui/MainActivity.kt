package com.example.myyoutube.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myyoutube.ui.adapter.PlaylistsAdapter
import com.example.myyoutube.R
import com.example.myyoutube.models.Playlist
import com.example.myyoutube.models.PlaylistItems
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list = mutableListOf<Playlist>()
    private lateinit var viewModel: PlaylistViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        fetchPlaylists()
    }

    private fun initRecycler(list: MutableList<PlaylistItems>) {
        val adapter = PlaylistsAdapter(list)
        playlists_rv.adapter = adapter
    }
    private fun fetchPlaylists() {
        viewModel.fetchPlaylists().observe(this, Observer {
            initRecycler(it?.items!!)
            Log.e("RESULT_FETCH_PLAYLISTS", it.toString())
        })
    }
}