package com.arech.pokedex.pokemon.list.data.source

import com.arech.pokedex.pokemon.list.data.remote.model.RemotePokemonResponse

/**
 * Created by Pili Arancibia on 29-07-22.
 */

interface PokemonListRemote {
    suspend fun getPokemonList(offset: Int, limit: Int) : RemotePokemonResponse
}