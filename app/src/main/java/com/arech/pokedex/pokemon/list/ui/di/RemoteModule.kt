package com.arech.pokedex.pokemon.list.ui.di

import com.arech.network.config.NetworkDependencies
import com.arech.network.retrofit.WebServiceFactory
import com.arech.pokedex.pokemon.list.data.remote.PokemonListRemoteImpl
import com.arech.pokedex.pokemon.list.data.remote.retrofit.PokemonListWebService
import com.arech.pokedex.pokemon.list.data.source.PokemonListRemote
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Pili Arancibia on 30-07-22.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {
    @Binds
    abstract fun bindRemote(remote: PokemonListRemoteImpl): PokemonListRemote

    companion object {
        @Provides
        fun providesWebServiceRetrofit(
            dependencies: NetworkDependencies,
        ): PokemonListWebService = WebServiceFactory(
            tClass = PokemonListWebService::class.java,
            context = dependencies.context,
        ).createWebServiceInstance(dependencies.flavorName)
    }
}