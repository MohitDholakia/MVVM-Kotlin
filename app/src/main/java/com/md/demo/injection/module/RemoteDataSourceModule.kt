package com.md.demo.injection.module

import com.google.gson.*
import com.md.demo.BuildConfig
import com.md.demo.data.remote.endpoint.WebService
import com.md.demo.misc.RequestInterceptor
import com.md.demo.misc.UnsafeOkHttpClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

val remoteDatasourceModule = applicationContext {

        //Request Interceptor
        bean { provideRequestInterceptor() }

        //Logging Interceptor
        bean { provideLoggingInterceptor() }

        // provided web components
        bean { provideOkHttpClient(get(), get()) }

        bean { provideGson() }

        bean { provideRemoteDataSource(get(), get()) }
}

/**
 * Try Json's parse for the application
 */
fun provideGson() : Gson {
        val builder = GsonBuilder()

        builder.registerTypeAdapter(Date::class.java, JsonDeserializer<Date> { json, _, _ ->
                json?.asJsonPrimitive?.asLong?.let {
                        return@JsonDeserializer Date(it)
                }
        })

        builder.registerTypeAdapter(Date::class.java, JsonSerializer<Date> { date, _, _ ->
                JsonPrimitive(date.time)
        })

        return builder.create()
}


/**
 * Try the interceptor of the requests. Used to add token header, for example.
 */
fun provideRequestInterceptor() : RequestInterceptor {
        return RequestInterceptor()
}

/**
 * Provides the requests logging interceptor
 */
fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        //Add log to requests
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return logInterceptor
}

/**
 * Provides the default httpClient for the App
 */
fun provideOkHttpClient(
        requestInterceptor : RequestInterceptor,
        logInterceptor : HttpLoggingInterceptor
) : OkHttpClient {

        val builder = UnsafeOkHttpClient.getUnsafeOkHttpClient()

        //Add interceptors
        builder.addInterceptor(logInterceptor)
        builder.addInterceptor(requestInterceptor)

        builder.connectTimeout(2, TimeUnit.MINUTES)
        builder.readTimeout(1, TimeUnit.MINUTES)
        builder.readTimeout(1, TimeUnit.MINUTES)

        return builder.build()
}

/**
 * Provides the endpoint service for the application
 */
fun provideRemoteDataSource(okHttpClient : OkHttpClient, gson : Gson) : WebService {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.URL_API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(WebService::class.java)
}
