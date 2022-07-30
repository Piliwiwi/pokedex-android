package com.arech.pokedex.pokemon.list.presentation.list

import com.arech.mvi.events.MviAction

/**
 * Created by Pili Arancibia on 30-07-22.
 */

sealed class ListAction : MviAction {
    object LoadPokemonListAction : ListAction()
}