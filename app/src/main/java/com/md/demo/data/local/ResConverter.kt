package com.md.demo.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.md.demo.data.model.Img

class ResConverter {
    @TypeConverter
    fun toTorrent(json: String): List<Img> {
        val type = object : TypeToken<List<Img>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(torrent: List<Img>): String {
        val type = object : TypeToken<List<Img>>() {}.type
        return Gson().toJson(torrent, type)
    }
}