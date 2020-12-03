package com.example.myyoutube.data.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detailPlaylist")
data class DetailPlayList(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long? = null,

    var kind: String? = null,

    var etag: String? = null,

    var nextPageToken: String? = null,

    var prevPageToken:String? = null,

    var items: MutableList<DetailVideo>? = null
)
data class DetailVideo(

    var kind: String? = null,

    var etag: String? = null,

    var id: String? = null,

    var snippet: Snippet? = null
)
