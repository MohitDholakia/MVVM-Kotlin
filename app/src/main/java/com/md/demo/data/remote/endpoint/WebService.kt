package com.md.demo.data.remote.endpoint

import com.md.demo.data.remote.dto.UserBean
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
        @GET("?results=100")
        suspend fun getRes() : Response<UserBean>
}