package com.md.demo.data.model

import com.google.gson.annotations.SerializedName

data class Img(
        @SerializedName("created_at")
        var createdAt: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("image")
        var image: String? = null,
        @SerializedName("main_id")
        var mainId: Int? = null,
        @SerializedName("updated_at")
        var updatedAt: String? = null
)