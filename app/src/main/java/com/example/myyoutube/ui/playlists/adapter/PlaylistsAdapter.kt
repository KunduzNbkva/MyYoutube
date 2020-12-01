package com.example.myyoutube.ui.playlists.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutube.R
import com.example.myyoutube.loadImage
import com.example.myyoutube.models.PlaylistItems
import kotlinx.android.synthetic.main.list_playlists.view.*


class PlaylistsAdapter(private var listener:(PlaylistItems)->Unit): RecyclerView.Adapter<PlaylistsAdapter.ViewHolder>() {
    var list=mutableListOf<PlaylistItems>()
    lateinit var holder: ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.list_playlists,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.holder=holder
        val item=list[position]
        holder.onBind(item)
        holder.itemView.setOnClickListener {
            listener(item)
        }
    }


    override fun getItemCount(): Int {
       return list.size
    }
    fun addItems(items: MutableList<PlaylistItems>) {
        this.list = items
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun onBind(item: PlaylistItems) {
            itemView.rootView.playlist_img.loadImage(item.snippet?.thumbnails?.medium?.url.toString())
            itemView.rootView.title_txt.text=item.snippet?.title
            itemView.rootView.quantity_txt.text=item.contentDetails?.itemCount
        }

    }
}
