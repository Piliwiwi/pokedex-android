package com.arech.pokedex.pokemon.list.data.local

import com.arech.pokedex.pokemon.list.data.local.database.dao.LocalRoomPokemonDao
import com.arech.pokedex.pokemon.list.data.local.database.entity.LocalPokemon
import com.arech.pokedex.pokemon.list.data.source.PokemonListLocal
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pili Arancibia on 30-07-22.
 */

class PokemonListLocalImpl @Inject constructor(
    private val dao: LocalRoomPokemonDao
) : PokemonListLocal {
    override suspend fun getPokemonList(): Flow<List<LocalPokemon>> = dao.getAll()
    override suspend fun savePokemon(pokemon: LocalPokemon) {
        dao.savePokemon(pokemon)
    }
}