package com.arech.network.config

sealed class Environment(val name: String) {
    object Remote : Environment(name = "remote")
    object Local : Environment(name = "local")
}
