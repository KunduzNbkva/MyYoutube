package com.example.myyoutube.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutube.R
import com.example.myyoutube.loadImage
import com.example.myyoutube.models.PlaylistItems
import kotlinx.android.synthetic.main.list_playlists.view.*


class PlaylistsAdapter(private val list: MutableList<PlaylistItems>): RecyclerView.Adapter<PlaylistsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.list_playlists,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }


    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        fun onBind(model: PlaylistItems) {
            itemView.rootView.playlist_img.loadImage(model.snippet?.thumbnails?.medium?.url.toString())
            itemView.rootView.title_txt.text=model.snippet?.title.toString()
            Log.e("TAG","title is "+model.snippet?.title.toString())
        }
    }
}
