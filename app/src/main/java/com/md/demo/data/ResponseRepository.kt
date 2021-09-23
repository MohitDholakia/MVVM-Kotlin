package com.md.demo.data

import com.md.demo.data.local.MyDatabase
import com.md.demo.data.model.UserResult
import com.md.demo.data.remote.endpoint.WebService

class ResponseRepository(
        private val remoteDataSource : WebService,
        private val localDataSource : MyDatabase
) {

        suspend fun getRecords() : List<UserResult> {
                //remote data source Request
                val list = remoteDataSource.getRes()
                localDataSource.myDao().deleteAll().apply {
                        list.body()?.results?.forEach {
                                localDataSource.myDao().insert(it)
                        }
                        return list.body()?.results!!
                }
        }

        suspend fun getOfflineRecords() : List<UserResult> {
                if (localDataSource.myDao().getDbList().isNotEmpty()) {
                        return localDataSource.myDao().getDbList();
                }
                return emptyList()
        }


}