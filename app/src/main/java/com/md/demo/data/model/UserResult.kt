package com.md.demo.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.md.demo.data.local.ResConverter
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "userBean")
@Parcelize
data class UserResult(
        @PrimaryKey(autoGenerate = true)
        val customKey : Int,
        @SerializedName("cell")
        val cell : String,
        @TypeConverters(ResConverter::class)
        val dob : Dob,
        @SerializedName("email")
        val email : String,
        @SerializedName("gender")
        val gender : String,
        @TypeConverters(ResConverter::class)
        val id : Id,
        @TypeConverters(ResConverter::class)
        val location : Location,
        @TypeConverters(ResConverter::class)
        val login : Login,
        @TypeConverters(ResConverter::class)
        val name : Name,
        @SerializedName("nat")
        val nat : String,
        @SerializedName("phone")
        val phone : String,
        @TypeConverters(ResConverter::class)
        val picture : Picture,
        @TypeConverters(ResConverter::class)
        val registered : Registered
) : Parcelable {
        @Parcelize
        data class Dob(
                @SerializedName("age")
                val age : Int,
                @SerializedName("date")
                val date : String
        ) : Parcelable

        @Parcelize
        data class Id(
                @SerializedName("name")
                val name : String,
                @SerializedName("value")
                val value : String
        ) : Parcelable

        @Parcelize
        data class Location(
                @SerializedName("city")
                val city : String,
                @TypeConverters(ResConverter::class)
                val coordinates : Coordinates,
                @SerializedName("country")
                val country : String,
                @SerializedName("postcode")
                val postcode : String,
                @SerializedName("state")
                val state : String,
                @TypeConverters(ResConverter::class)
                val street : Street,
                @TypeConverters(ResConverter::class)
                val timezone : Timezone
        ) : Parcelable {

                @Parcelize
                data class Coordinates(
                        @SerializedName("latitude")
                        val latitude : String,
                        @SerializedName("longitude")
                        val longitude : String
                ) : Parcelable

                @Parcelize
                data class Street(
                        @SerializedName("name")
                        val name : String,
                        @SerializedName("number")
                        val number : Int
                ) : Parcelable

                @Parcelize
                data class Timezone(
                        @SerializedName("description")
                        val description : String,
                        @SerializedName("offset")
                        val offset : String
                ) : Parcelable
        }

        @Parcelize
        data class Login(
                @SerializedName("md5")
                val md5 : String,
                @SerializedName("password")
                val password : String,
                @SerializedName("salt")
                val salt : String,
                @SerializedName("sha1")
                val sha1 : String,
                @SerializedName("sha256")
                val sha256 : String,
                @SerializedName("username")
                val username : String,
                @SerializedName("uuid")
                val uuid : String
        ) : Parcelable

        @Parcelize
        data class Name(
                @SerializedName("first")
                val first : String,
                @SerializedName("last")
                val last : String,
                @SerializedName("title")
                val title : String
        ) : Parcelable

        @Parcelize
        data class Picture(
                @SerializedName("large")
                val large : String,
                @SerializedName("medium")
                val medium : String,
                @SerializedName("thumbnail")
                val thumbnail : String
        ) : Parcelable

        @Parcelize
        data class Registered(
                @SerializedName("age")
                val age : Int,
                @SerializedName("date")
                val date : String
        ) : Parcelable
}