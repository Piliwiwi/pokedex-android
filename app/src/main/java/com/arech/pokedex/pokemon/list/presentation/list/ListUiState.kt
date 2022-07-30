package com.arech.pokedex.pokemon.list.presentation.list

import com.arech.mvi.events.MviUiState
import com.arech.pokedex.pokemon.list.presentation.list.model.Pokemon

/**
 * Created by Pili Arancibia on 30-07-22.
 */

sealed class ListUiState : MviUiState {
    object DefaultUiState : ListUiState()
    object LoadingUiState : ListUiState()
    object ErrorUiState : ListUiState()
    data class ShowPokemonsUiState(val pokemons: List<Pokemon>) : ListUiState()
}