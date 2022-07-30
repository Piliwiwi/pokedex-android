package com.arech.pokedex.pokemon.list.presentation.list

import com.arech.mvi.MviReducer
import com.arech.mvi.exception.UnsupportedReduceException
import com.arech.pokedex.pokemon.list.presentation.list.ListResult.LoadPokemonListResult
import com.arech.pokedex.pokemon.list.presentation.list.ListResult.LoadPokemonListResult.Complete
import com.arech.pokedex.pokemon.list.presentation.list.ListResult.LoadPokemonListResult.InProgress
import com.arech.pokedex.pokemon.list.presentation.list.ListResult.LoadPokemonListResult.Success
import com.arech.pokedex.pokemon.list.presentation.list.ListUiState.DefaultUiState
import com.arech.pokedex.pokemon.list.presentation.list.ListUiState.ErrorUiState
import com.arech.pokedex.pokemon.list.presentation.list.ListUiState.LoadingUiState
import com.arech.pokedex.pokemon.list.presentation.list.ListUiState.ShowPokemonsUiState
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 30-07-22.
 */

class ListReducer @Inject constructor() : MviReducer<ListUiState, ListResult> {
    override fun ListUiState.reduce(result: ListResult): ListUiState {
        return when (val currentState = this) {
            is DefaultUiState -> currentState reduceWith result
            is ErrorUiState -> currentState reduceWith result
            is LoadingUiState -> currentState reduceWith result
            is ShowPokemonsUiState -> currentState reduceWith result
        }
    }

    private infix fun DefaultUiState.reduceWith(result: ListResult): ListUiState {
        return when (result) {
            InProgress -> LoadingUiState
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun ErrorUiState.reduceWith(result: ListResult): ListUiState {
        return when (result) {
            InProgress -> LoadingUiState
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun LoadingUiState.reduceWith(result: ListResult): ListUiState {
        return when (result) {
            LoadPokemonListResult.Error -> ErrorUiState
            is Success -> ShowPokemonsUiState(result.pokemons)
            is Complete -> ShowPokemonsUiState(result.pokemon)
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun ShowPokemonsUiState.reduceWith(result: ListResult): ListUiState {
        return when (result) {
            LoadPokemonListResult.Error -> ErrorUiState
            InProgress -> LoadingUiState
            is Complete -> this
            is Success -> ShowPokemonsUiState(result.pokemons)
            else -> throw UnsupportedReduceException(this, result)
        }
    }
}