package com.arech.pokedex.common.factory

import android.content.Context
import com.arech.network.config.NetworkDependencies
import com.arech.pokedex.BuildConfig

/**
 * Created by Pili Arancibia on 29-07-22.
 */

object NetworkDependenciesFactory {
    fun makeNetworkDependencies(context: Context): NetworkDependencies =
        NetworkDependencies(
            flavorName = BuildConfig.FLAVOR,
            context = context
        )
}