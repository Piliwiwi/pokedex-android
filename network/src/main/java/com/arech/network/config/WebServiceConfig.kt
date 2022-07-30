package com.arech.network.config

object WebServiceConfig {
    object Url {
        const val REMOTE_HOST = "https://pokeapi.co/api/v2/"
        const val LOCAL_HOST = "http://mock.api/"
    }

    object Timeout {
        const val CONNECT: Long = 60
    }
}