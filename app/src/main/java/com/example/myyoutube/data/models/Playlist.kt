package com.example.myyoutube.data.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "playlist")
data class Playlist(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("idRoom")
    var id: Int? = null,
    @SerializedName("id")
    var apiId: String? = null,
    var kind: String? = null,
    var etag: String? = null,
    var items: MutableList<PlaylistItems>? = null,
    var nextPageToken: String? = null
)


data class PlaylistItems(
    @SerializedName("id")
    var apiId: String? = null,
    var kind: String? = null,
    var etag: String? = null,
    var snippet: Snippet? = null,
    var contentDetails: ContentDetails? = null,
    var nextPageToken: String? = null
):Serializable

data class Snippet(
    var publishedAt: String? = null,
    var channelId: String? = null,
    var title: String? = null,
    var description: String? = null,
    var thumbnails: Thumbnails? = null,
    var resourceId: ResourceId?=null,
    var playlistId: String? = null
):Serializable

data class Thumbnails(
    var medium: Medium? = null
):Serializable

data class Medium(
    var url: String? = null
):Serializable

data class ContentDetails(
    var itemCount: String? = null
):Serializable