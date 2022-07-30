package com.arech.pokedex.pokemon.list.presentation.list

import com.arech.mvi.events.MviResult
import com.arech.pokedex.pokemon.list.presentation.list.model.Pokemon

/**
 * Created by Pili Arancibia on 30-07-22.
 */

sealed class ListResult : MviResult {
    sealed class LoadPokemonListResult : ListResult() {
        object InProgress : LoadPokemonListResult()
        object Error : LoadPokemonListResult()
        data class Complete(val pokemon: List<Pokemon>) : LoadPokemonListResult()
        data class Success(val pokemons: List<Pokemon>) : LoadPokemonListResult()
    }
}