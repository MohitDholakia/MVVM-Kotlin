package com.md.demo.misc

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain?.request()
        val newRequest = request?.newBuilder()

        //get the token
        try {
            newRequest?.addHeader("Accept", "application/json")

//            val token = dataBase.getToken().toBlocking().first()
//            val token = AutoVistoriaApplication.token

            //if token is not null try to add to header
//            token?.let {
//                newRequest?.addHeader(RemoteConstants.AUTHORIZATION, it.token)
//            }
        } catch (ex: Throwable) {
            Log.d("WARN", "Interceptor \n$ex")
        }

        return chain?.proceed(newRequest!!.build())!!
    }
}