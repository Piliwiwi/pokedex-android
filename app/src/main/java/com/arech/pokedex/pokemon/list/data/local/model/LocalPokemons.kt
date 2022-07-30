package com.arech.pokedex.pokemon.list.data.local.model

import com.arech.pokedex.pokemon.list.data.local.database.entity.LocalPokemon

/**
 * Created by Pili Arancibia on 30-07-22.
 */

data class LocalPokemons(
    val pokemons: List<LocalPokemon>
)