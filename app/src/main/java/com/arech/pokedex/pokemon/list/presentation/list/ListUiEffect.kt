package com.arech.pokedex.pokemon.list.presentation.list

import com.arech.mvi.events.MviEffect
import com.arech.pokedex.pokemon.list.presentation.list.model.Pokemon

/**
 * Created by Pili Arancibia on 30-07-22.
 */

sealed class ListUiEffect : MviEffect {
    data class ShowMorePokemons(val pokemons: List<Pokemon>) : ListUiEffect()
}