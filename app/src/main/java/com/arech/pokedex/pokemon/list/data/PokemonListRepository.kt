package com.arech.pokedex.pokemon.list.data

import com.arech.pokedex.pokemon.list.data.source.PokemonListRemote
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

/**
 * Created by Pili Arancibia on 29-07-22.
 */

class PokemonListRepository @Inject constructor(
    private val remote: PokemonListRemote
) {
    fun getPokemonList() = flow {
        val list = remote.getPokemonList()
        emit(list)
    }
}