package com.arech.network.retrofit

import com.arech.network.config.WebServiceConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.SocketFactory

class RemoteWebService<TRetrofitWebService> {

    fun create(
        tClass: Class<TRetrofitWebService>,
        baseUrl: String,
    ): TRetrofitWebService {
        val okHttpClient = makeOkHttpClient(
            httpLoggingInterceptor = makeLoggingInterceptor()
        )
        return createRetrofit(
            okHttpClient = okHttpClient,
            tClass = tClass,
            baseUrl = baseUrl
        )
    }

    private fun makeOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .socketFactory(SocketFactory.getDefault())
            .connectTimeout(WebServiceConfig.Timeout.CONNECT, TimeUnit.SECONDS)
            .build()

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    private fun createRetrofit(
        okHttpClient: OkHttpClient,
        tClass: Class<TRetrofitWebService>,
        baseUrl: String,
    ): TRetrofitWebService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(tClass)
}