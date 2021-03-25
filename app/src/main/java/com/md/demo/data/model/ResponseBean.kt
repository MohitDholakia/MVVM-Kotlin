/*************************************************
 * Created by Efendi Hariyadi on 23/3/21 10:34 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 23/3/21 10:34 PM
 ************************************************/

package com.md.demo.data.model


import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.md.demo.data.local.ResConverter


@Entity(tableName = "responseBean")
data class ResponseBean(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @SerializedName("address")
        var address: String? = null,
        @SerializedName("city")
        var city: String? = null,
        @SerializedName("country")
        var country: String? = null,
        @SerializedName("created_at")
        var createdAt: String? = null,
        @SerializedName("description")
        var description: String? = null,
        @TypeConverters(ResConverter::class)
        var img: List<Img>,
        @SerializedName("lat")
        var lat: String? = null,
        @SerializedName("long")
        var long: String? = null,
        @SerializedName("phone_no")
        var phoneNo: Long? = null,
        @SerializedName("pincode")
        var pincode: Int? = null,
        @SerializedName("rating")
        var rating: Int? = null,
        @SerializedName("state")
        var state: String? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("updated_at")
        var updatedAt: String? = null
) {
    constructor() : this(0, "", "", "", "", "", arrayListOf(), "")
}


