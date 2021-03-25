/*************************************************
 * Created by Efendi Hariyadi on 23/3/21 11:07 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 23/3/21 11:07 PM
 ************************************************/

package com.md.demo.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.md.demo.data.model.ResponseBean

data class ListResponse(
        @SerializedName("data")
        val mData: List<ResponseBean>,
        @SerializedName("status")
        val status: Int
)
