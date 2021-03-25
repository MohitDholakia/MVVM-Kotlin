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
        if (localDataSource.myDao().getDbList().isNotEmpty()) {
            return localDataSource.myDao().getDbList();
        } else {
            val list = remoteDataSource.getRes()
            /*list.enqueue(object : Callback<ListResponse> {
                override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                }

                override fun onResponse(call: Call<ListResponse>, response: Response<ListResponse>) {
                    response.body()?.mData?.forEach {
                        localDataSource.myDao().insert(it)
                    }
                }
            })*/
            list.body()?.mData?.forEach {
                localDataSource.myDao().insert(it)
            }
            return list.body()?.mData!!
        }
    }

    suspend fun queryDatabase() {
        //Database query example
//        val sizeDeffered = async {
//            localDataSource.rateDao().getRates().size
//        }
//        Timber.e("erro: ${sizeDeffered.await()}")
    }
}