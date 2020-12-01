package com.example.myyoutube.models

data class DetailPlayList(
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
