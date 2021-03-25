package com.md.demo.data.remote.endpoint

import com.md.demo.data.remote.dto.ListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface WebService {

    @GET("restaurants_list")
   suspend fun getRes(): Response<ListResponse>
}