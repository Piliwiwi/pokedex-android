package com.arech.pokedex.pokemon.list.data.remote

import com.arech.pokedex.pokemon.list.data.remote.retrofit.PokemonListWebService
import com.arech.pokedex.pokemon.list.data.source.PokemonListRemote
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 29-07-22.
 */

class PokemonListRemoteImpl @Inject constructor(
    private val api: PokemonListWebService
) : PokemonListRemote {
    override suspend fun getPokemonList() = api.getPokemonList()
}