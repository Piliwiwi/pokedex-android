package com.arech.pokedex.pokemon.list.presentation.list

import com.arech.mvi.events.MviUserIntent

/**
 * Created by Pili Arancibia on 30-07-22.
 */

sealed class ListUIntent : MviUserIntent {
    object InitialUIntent : ListUIntent()
}