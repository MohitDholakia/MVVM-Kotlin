package com.md.demo.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.md.demo.data.model.UserResult
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserBean(
        @SerializedName("info")
        val info : Info,
        @SerializedName("results")
        val results : List<UserResult>
) : Parcelable {

        @Parcelize
        data class Info(
                @SerializedName("page")
                val page : Int,
                @SerializedName("results")
                val results : Int,
                @SerializedName("seed")
                val seed : String,
                @SerializedName("version")
                val version : String
        ) : Parcelable


}