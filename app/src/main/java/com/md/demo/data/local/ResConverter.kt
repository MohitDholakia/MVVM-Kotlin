package com.md.demo.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.md.demo.data.model.UserResult

class ResConverter {
        @TypeConverter
        fun toDoB(json : String) : UserResult.Dob {
                val type = object : TypeToken<UserResult.Dob>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonDoB(torrent : UserResult.Dob) : String {
                val type = object : TypeToken<UserResult.Dob>() {}.type
                return Gson().toJson(torrent, type)
        }


        @TypeConverter
        fun toId(json : String) : UserResult.Id {
                val type = object : TypeToken<UserResult.Id>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonId(torrent : UserResult.Id) : String {
                val type = object : TypeToken<UserResult.Id>() {}.type
                return Gson().toJson(torrent, type)
        }

        @TypeConverter
        fun toLocation(json : String) : UserResult.Location {
                val type = object : TypeToken<UserResult.Location>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonLocation(torrent : UserResult.Location) : String {
                val type = object : TypeToken<UserResult.Location>() {}.type
                return Gson().toJson(torrent, type)
        }


        @TypeConverter
        fun toLogin(json : String) : UserResult.Login {
                val type = object : TypeToken<UserResult.Login>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonLogin(torrent : UserResult.Login) : String {
                val type = object : TypeToken<UserResult.Login>() {}.type
                return Gson().toJson(torrent, type)
        }

        @TypeConverter
        fun toName(json : String) : UserResult.Name {
                val type = object : TypeToken<UserResult.Name>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonName(torrent : UserResult.Name) : String {
                val type = object : TypeToken<UserResult.Name>() {}.type
                return Gson().toJson(torrent, type)
        }

        @TypeConverter
        fun toPicture(json : String) : UserResult.Picture {
                val type = object : TypeToken<UserResult.Picture>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonPicture(torrent : UserResult.Picture) : String {
                val type = object : TypeToken<UserResult.Picture>() {}.type
                return Gson().toJson(torrent, type)
        }

        @TypeConverter
        fun toRegistered(json : String) : UserResult.Registered {
                val type = object : TypeToken<UserResult.Registered>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonRegistered(torrent : UserResult.Registered) : String {
                val type = object : TypeToken<UserResult.Registered>() {}.type
                return Gson().toJson(torrent, type)
        }


        @TypeConverter
        fun toCoordinates(json : String) : UserResult.Location.Coordinates {
                val type = object : TypeToken<UserResult.Location.Coordinates>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonCoordinates(torrent : UserResult.Location.Coordinates) : String {
                val type = object : TypeToken<UserResult.Location.Coordinates>() {}.type
                return Gson().toJson(torrent, type)
        }

        @TypeConverter
        fun toStreet(json : String) : UserResult.Location.Street {
                val type = object : TypeToken<UserResult.Location.Street>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonStreet(torrent : UserResult.Location.Street) : String {
                val type = object : TypeToken<UserResult.Location.Street>() {}.type
                return Gson().toJson(torrent, type)
        }

        @TypeConverter
        fun toTimezone(json : String) : UserResult.Location.Timezone {
                val type = object : TypeToken<UserResult.Location.Timezone>() {}.type
                return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun toJsonTimezone(torrent : UserResult.Location.Timezone) : String {
                val type = object : TypeToken<UserResult.Location.Timezone>() {}.type
                return Gson().toJson(torrent, type)
        }


}