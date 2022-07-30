package com.arech.pokedex.pokemon.list.data

import com.arech.pokedex.pokemon.list.data.local.database.entity.LocalPokemon
import com.arech.pokedex.pokemon.list.data.local.mapper.LocalPokemonMapper
import com.arech.pokedex.pokemon.list.data.source.PokemonListLocal
import com.arech.pokedex.pokemon.list.data.source.PokemonListRemote
import javax.inject.Inject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

/**
 * Created by Pili Arancibia on 29-07-22.
 */

class PokemonListRepository @Inject constructor(
    private val remote: PokemonListRemote,
    private val local: PokemonListLocal,
    private val mapper: LocalPokemonMapper
) {
    suspend fun savePokemons() {
        GlobalScope.launch {
            (0..10).map {
                delay(1000)
                remote.getPokemonList(it, 10).results?.map {
                    val localPokemon = with(mapper) { it.toLocal() }
                    local.savePokemon(localPokemon)
                }
            } }
    }

    suspend fun getLocalPokemon(): Flow<List<LocalPokemon>> = local.getPokemonList()
}