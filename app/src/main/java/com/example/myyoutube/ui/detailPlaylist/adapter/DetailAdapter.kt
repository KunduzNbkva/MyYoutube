package com.example.myyoutube.ui.detailPlaylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myyoutube.R
import com.example.myyoutube.loadImage
import com.example.myyoutube.models.PlaylistItems
import kotlinx.android.synthetic.main.activity_info.view.*
import kotlinx.android.synthetic.main.list_playlists.view.*

class DetailAdapter(private var onItemClick: (PlaylistItems) -> Unit) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    private var list = mutableListOf<PlaylistItems>()

    private lateinit var holder: ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_playlists, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.holder = holder
        val item = list[position]
        holder.onBind(item)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    fun addItems(items: MutableList<PlaylistItems>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: PlaylistItems) {
        list.add(item)
        notifyItemInserted(list.lastIndex)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(item: PlaylistItems) {
            itemView.rootView.playlist_img.loadImage(item.snippet?.thumbnails?.medium?.url.toString())
            itemView.rootView.title_txt.text = item.snippet?.title
            itemView.rootView.quantity_txt.visibility=View.INVISIBLE
            itemView.rootView.series_txt.visibility = View.INVISIBLE
            itemView.rootView.playlist.visibility=View.INVISIBLE
        }
    }
}