package com.arech.pokedex.pokemon.list.data.source

import com.arech.pokedex.pokemon.list.data.local.database.entity.LocalPokemon
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pili Arancibia on 30-07-22.
 */

interface PokemonListLocal {
    suspend fun getPokemonList(): Flow<List<LocalPokemon>>
    suspend fun savePokemon(pokemon: LocalPokemon)
}