package com.example.myyoutube.ui.detailPlaylist

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myyoutube.R
import com.example.myyoutube.loadImage
import com.example.myyoutube.models.PlaylistItems
import com.example.myyoutube.network.Status
import com.example.myyoutube.showToastShort
import com.example.myyoutube.ui.detailPlaylist.adapter.DetailAdapter
import com.example.myyoutube.ui.playlists.PlaylistViewModel
import com.example.myyoutube.ui.playlists.adapter.PlaylistsAdapter
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_scrolling.*

class DetailPlaylistActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailPlaylistViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailPlaylistViewModel::class.java)
        fetchDetailPlaylist()
        setContentView(R.layout.activity_info)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title =""
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initRecycler(list: MutableList<PlaylistItems>) {
        val adapter = DetailAdapter() { { item: PlaylistItems -> this.onItemClick(item) } }
        adapter.addItems(list)
        list[0].snippet?.thumbnails?.medium?.url?.let { playlists_image.loadImage(it) }
        videos_rv.adapter=adapter
    }

    private  fun fetchDetailPlaylist(){
       viewModel.fetchDetailPlayLists(playListId!!,null).observe(this, Observer {
            when(it.status){
                Status.SUCCESS->it.data?.items?.let { it1 -> initRecycler(it1) }
            }

       })
    }
    private fun onItemClick(item: PlaylistItems) {
       showToastShort("CLick is working")
    }


    companion object{
        var playListId:String?=null
        var title:String?=null
        fun instanceActivity(activity: Activity?, playListId:String,title:String){
            val intent = Intent(activity, DetailPlaylistActivity::class.java)
            this.playListId = playListId
            this.title=title
            activity?.startActivity(intent)
        }
    }


}