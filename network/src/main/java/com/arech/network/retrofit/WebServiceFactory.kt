package com.arech.network.retrofit

import android.content.Context
import com.arech.network.config.Environment
import com.arech.network.config.WebServiceConfig.Url
import com.arech.network.retrofit.exception.InvalidEnvironmentException

class WebServiceFactory<TWebService> constructor(
    private val tClass: Class<TWebService>,
    private val context: Context,
) {

    fun createWebServiceInstance(environment: String): TWebService {
        return when (environment) {
            Environment.Local.name -> createLocalWebServiceConfig()
            Environment.Remote.name -> createRemoteWebServiceConfig(
                baseUrl = Url.REMOTE_HOST,
            )
            else -> throw InvalidEnvironmentException("Current environment $environment is not supported")
        }
    }

    private fun createLocalWebServiceConfig(): TWebService =
        LocalWebService<TWebService>().create(
            context = context,
            tClass = tClass,
            hostUrl = Url.LOCAL_HOST
        )

    private fun createRemoteWebServiceConfig(
        baseUrl: String,
    ): TWebService {
        return RemoteWebService<TWebService>().create(
            tClass = tClass,
            baseUrl = baseUrl
        )
    }
}