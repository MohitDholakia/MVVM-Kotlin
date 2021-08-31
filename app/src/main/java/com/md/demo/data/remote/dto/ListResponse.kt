package com.md.demo.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.md.demo.data.model.ResponseBean

data class ListResponse(
        @SerializedName("data")
        val mData: List<ResponseBean>,
        @SerializedName("status")
        val status: Int
)
