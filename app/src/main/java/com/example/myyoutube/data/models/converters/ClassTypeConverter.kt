package com.example.myyoutube.data.models.converters

import androidx.room.TypeConverter
import com.example.myyoutube.data.models.ContentDetails
import com.example.myyoutube.data.models.PlaylistItems
import com.example.myyoutube.data.models.Snippet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ClassTypeConverter {

    @TypeConverter
    fun toJsonPlayList(resultModels: MutableList<PlaylistItems>?): String? {
        if (resultModels == null) return null
        val gson = Gson()
        val type =
            object : TypeToken<MutableList<PlaylistItems>?>() {}.type
        return gson.toJson(resultModels, type)
    }

    @TypeConverter
    fun fromJsonPlayList(json: String?): MutableList<PlaylistItems>? {
        if (json == null) return null
        val gson = Gson()
        val type =
            object : TypeToken<MutableList<PlaylistItems>?>() {}.type
        return gson.fromJson(json, type)
    }
}