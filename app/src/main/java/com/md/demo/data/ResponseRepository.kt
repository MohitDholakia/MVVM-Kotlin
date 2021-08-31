package com.md.demo.data

import com.md.demo.data.local.MyDatabase
import com.md.demo.data.model.ResponseBean
import com.md.demo.data.remote.dto.ListResponse
import com.md.demo.data.remote.endpoint.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseRepository(private val remoteDataSource: WebService,
                         private val localDataSource: MyDatabase) {


    suspend fun getRecords(): List<ResponseBean> {
        //remote data source Request
        return if (localDataSource.myDao().getDbList().isNotEmpty()) {
            localDataSource.myDao().getDbList();
        } else {
            val list = remoteDataSource.getRes()
            list.body()?.mData?.forEach {
                localDataSource.myDao().insert(it)
            }
            list.body()?.mData!!
        }
    }

}